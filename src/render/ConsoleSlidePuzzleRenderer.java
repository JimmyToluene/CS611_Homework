package render;
import core.SlidePuzzleBoard;
import io.GameIO;

public class ConsoleSlidePuzzleRenderer implements BoardRenderer<SlidePuzzleBoard> {
    private static String repeat(String s, int count) {
        return s.repeat(Math.max(0, count));
    }

    @Override public void render(SlidePuzzleBoard board, GameIO io) {
        int[] a = board.getBoard();
        int n = board.getBoardLength();
        int width = (String.valueOf(n).length()) * 2; // your previous logic

        io.println(repeat("+---", n) + "+");
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder("|");
            for (int j = 0; j < n; j++) {
                int v = a[i * n + j];
                String cell = (v == 0) ? "  " : String.valueOf(v);
                row.append(String.format("%"+width+"s |", cell));
            }
            io.println(row.toString());
            io.println(repeat("+---", n) + "+");
        }
    }
}