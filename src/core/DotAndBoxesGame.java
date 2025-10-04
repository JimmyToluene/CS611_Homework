package core;

import io.GameIO;
import prompt.Prompter;
import render.BoardRenderer;

public class DotAndBoxesGame extends Game<DotAndBoxesBoard>{
    private final Player[] players;
    private int currentPlayerIndex;

    @Override
    protected void initBoard(int row,int column) {
        horizEdges = new String[row][column - 1];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column - 1; c++) {
                horizontalEdges[r][c] = "0";
            }
        }
        verticalEdges = new String[row - 1][column];
        for (int r = 0; r < row-1; r++) {
            for (int c = 0; c < column; c++) {
                verticalEdges[r][c] = "0";
            }
        }
    }
    public DotAndBoxesGame(Player p1,Player p2,int rows,int cols) {
        initBoard();

    }

}
