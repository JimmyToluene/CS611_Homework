package controller;
import prompt.Prompter;
import io.GameIO;
import core.SlidePuzzleBoard;
import render.BoardRenderer;

import java.util.ArrayList;
import java.util.List;

public class SlidePuzzleController {
    private final GameIO io;
    private final Prompter prompts;
    private final BoardRenderer<SlidePuzzleBoard> renderer;

    public SlidePuzzleController(GameIO io, Prompter prompts, BoardRenderer<SlidePuzzleBoard> renderer) {
        this.io = io;
        this.prompts = prompts;
        this.renderer = renderer;
    }


    public void run(SlidePuzzleBoard board) {
        while (!java.util.Arrays.equals(board.getBoard(), board.getTargetBoard())) {
            renderer.render(board, io);
            io.println(prompts.askMove());

            List<Integer> valid = movableTiles(board);
            io.println("Valid moves: " + valid);

            Integer choice = readChoice(valid);
            if (choice == null) continue;

            applyMove(board, choice);
            io.println(prompts.splitLine());
        }
        io.println(prompts.win());
    }

    private Integer readChoice(List<Integer> valid) {
        String s = io.readLine();
        try {
            int c = Integer.parseInt(s.trim());
            if (!valid.contains(c)) {
                io.printError(prompts.errorInvalidMove(valid));
                return null;
            }
            return c;
        } catch (NumberFormatException e) {
            io.printError(prompts.errorInvalidMove(valid));
            return null;
        }
    }

    private List<Integer> movableTiles(SlidePuzzleBoard b) {
        int[] a = b.getBoard();
        int n = b.getBoardLength();
        // find zero
        int zi = -1, zj = -1;
        outer: for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i*n + j] == 0) { zi = i; zj = j; break outer; }

        List<Integer> moves = new ArrayList<>();
        if (zj-1 >= 0)     moves.add(a[zi*n + (zj-1)]);
        if (zj+1 < n)      moves.add(a[zi*n + (zj+1)]);
        if (zi-1 >= 0)     moves.add(a[(zi-1)*n + zj]);
        if (zi+1 < n)      moves.add(a[(zi+1)*n + zj]);
        // filter out zeros
        moves.removeIf(v -> v == 0);
        return moves;
    }

    private void applyMove(SlidePuzzleBoard b, int choice) {
        int[] a = b.getBoard();
        int n = b.getBoardLength();
        // find zero
        int zi = -1, zj = -1;
        outer: for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i*n + j] == 0) { zi = i; zj = j; break outer; }

        // find chosen tile
        int ci = -1, cj = -1;
        outer: for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i*n + j] == choice) { ci = i; cj = j; break outer; }

        // swap
        b.swap(zi*n + zj, ci*n + cj);
    }
}
