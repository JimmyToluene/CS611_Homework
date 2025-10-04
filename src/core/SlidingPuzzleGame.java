package core;

import io.GameIO;
import prompt.Prompter;
import render.BoardRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Concrete implementation of the classic sliding puzzle using the
 * {@link Game} framework.  A sliding puzzle board consists of numbered
 * tiles arranged in a square with one blank space.  The goal is to slide
 * tiles into the blank until the board is in ascending order.
 */
public class SlidingPuzzleGame extends Game<Board> {
    private final int size;
    private final int scrambleSteps;

    /**
     * Construct a new sliding puzzle game with the given board size and
     * number of random scramble moves.  The scramble step count controls
     * how "shuffled" the board is at the start of play.
     *
     * @param io game I/O interface
     * @param prompter message provider for prompts and errors
     * @param renderer board renderer
     * @param size dimension of the board (>= 2)
     * @param scrambleSteps number of random moves used to scramble the board
     */
    public SlidingPuzzleGame(GameIO io, Prompter prompter,
                             BoardRenderer<Board> renderer, int size,
                             int scrambleSteps) {
        super(io, prompter, renderer);
        this.size = size;
        this.scrambleSteps = scrambleSteps;
    }

    /** Initialise the board by creating tiles, populating them with pieces
     * in solved order, then randomly scrambling the configuration. */
    @Override
    protected void initBoard() {
        board = new Board(size);
        int value = 1;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Tile tile = new Tile(r, c);
                board.tiles[r][c] = tile;
                if (r == size - 1 && c == size - 1) {
                    tile.setPiece(new Piece(0)); // blank piece
                } else {
                    tile.setPiece(new Piece(value++));
                }
            }
        }
        scrambleBoard();
    }

    /**
     * Randomly scramble the board by performing a sequence of legal moves.
     * A truly random permutation of the board may produce unsolvable boards;
     * performing legal moves preserves solvability.
     */
    private void scrambleBoard() {
        Random rng = new Random();
        int blankRow, blankCol;
        for (int i = 0; i < scrambleSteps; i++) {
            // find blank coordinates
            blankRow = -1; blankCol = -1;
            outer: for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    if (board.getTile(r, c).getPiece().getValue() == 0) {
                        blankRow = r; blankCol = c;
                        break outer;
                    }
                }
            }
            // collect neighbor positions of the blank
            List<int[]> neighbors = new ArrayList<>();
            if (blankRow > 0) neighbors.add(new int[]{blankRow - 1, blankCol});
            if (blankRow < size - 1) neighbors.add(new int[]{blankRow + 1, blankCol});
            if (blankCol > 0) neighbors.add(new int[]{blankRow, blankCol - 1});
            if (blankCol < size - 1) neighbors.add(new int[]{blankRow, blankCol + 1});
            int[] target = neighbors.get(rng.nextInt(neighbors.size()));
            swap(blankRow, blankCol, target[0], target[1]);
        }
    }

    /** Swap the pieces at two tile positions. */
    private void swap(int r1, int c1, int r2, int c2) {
        Piece temp = board.getTile(r1, c1).getPiece();
        board.getTile(r1, c1).setPiece(board.getTile(r2, c2).getPiece());
        board.getTile(r2, c2).setPiece(temp);
    }

    /**
     * Determine whether the current board configuration is in solved order.
     * Tiles are ordered row‑major from 1 up to N×N−1, with the blank (0)
     * occupying the last position.
     */
    @Override
    protected boolean isSolved() {
        int expected = 1;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                int val = board.getTile(r, c).getPiece().getValue();
                if (r == size - 1 && c == size - 1) {
                    return val == 0;
                }
                if (val != expected++) return false;
            }
        }
        return true;
    }

    /**
     * Prompt the player for a move, validate the input and update the board.
     * Only tiles adjacent to the blank may be moved.  Invalid input is
     * reported using the prompter's error messages and does not change state.
     */
    @Override
    protected void move() {
        // locate blank tile
        int blankRow = -1, blankCol = -1;
        outer: for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board.getTile(r, c).getPiece().getValue() == 0) {
                    blankRow = r;
                    blankCol = c;
                    break outer;
                }
            }
        }
        // gather legal moves (values of adjacent pieces)
        List<Integer> valid = new ArrayList<>();
        if (blankRow > 0) valid.add(board.getTile(blankRow - 1, blankCol).getPiece().getValue());
        if (blankRow < size - 1) valid.add(board.getTile(blankRow + 1, blankCol).getPiece().getValue());
        if (blankCol > 0) valid.add(board.getTile(blankRow, blankCol - 1).getPiece().getValue());
        if (blankCol < size - 1) valid.add(board.getTile(blankRow, blankCol + 1).getPiece().getValue());
        valid.removeIf(v -> v == 0);
        io.println(prompter.askMove());
        io.println("Valid moves: " + valid);
        String input = io.readLine();
        try {
            int choice = Integer.parseInt(input.trim());
            if (!valid.contains(choice)) {
                io.printError(prompter.errorInvalidMove(valid));
                return;
            }
            // locate chosen tile among neighbors
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    if (board.getTile(r, c).getPiece().getValue() == choice &&
                        Math.abs(r - blankRow) + Math.abs(c - blankCol) == 1) {
                        swap(blankRow, blankCol, r, c);
                        return;
                    }
                }
            }
        } catch (NumberFormatException e) {
            io.printError(prompter.errorInvalidMove(valid));
        }
    }
}