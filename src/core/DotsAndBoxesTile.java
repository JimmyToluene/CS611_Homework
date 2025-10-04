/*package core;

import io.GameIO;
import prompt.Prompter;
import render.BoardRenderer;

public class DotsAndBoxesTile extends Game<Board> {
    private int row;
    private int column;


    public DotsAndBoxesTile(GameIO io, Prompter prompter,
                            BoardRenderer<Board> renderer, int size,
                            int scrambleSteps) {
        super(io, prompter, renderer);
        initBoard(row,column);
    }

    @Override
    protected void initBoard(int row,int column) {
        horizontalEdges = new String[row][column - 1];
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

    @Override
    protected void initBoard() {
        board = new Board();
        Board horizontalEdges = new Board(row, column - 1);

    }

    @Override
    protected boolean isSolved() {
        return false;
    }

    @Override
    protected void move() {

    }
}*/