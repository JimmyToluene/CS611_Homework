package render;

import core.Board;
import core.Piece;
import io.GameIO;

/**
 * Concrete renderer that outputs a textual representation of a {@link Board} to
 * a {@link GameIO}.  Each row is separated by horizontal separators and
 * numbers are right‑aligned to a width of two characters for legibility.
 */
public class ConsoleBoardRenderer implements BoardRenderer<Board> {
    @Override
    public void render(Board board, GameIO io) {
        int n = board.getSize();
        String horizontal = "+---".repeat(n) + "+";
        io.println(horizontal);
        for (int r = 0; r < n; r++) {
            StringBuilder row = new StringBuilder("|");
            for (int c = 0; c < n; c++) {
                Piece piece = board.getTile(r, c).getPiece();
                String val = piece.getValue() == 0 ? "  " : String.format("%2d", piece.getValue());
                row.append(val).append(" |");
            }
            io.println(row.toString());
            io.println(horizontal);
        }
    }
}