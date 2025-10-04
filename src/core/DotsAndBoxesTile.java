package core;

public class DotsAndBoxesTile extends GameTile {
    private String[][] horizontalEdges;
    private String[][] verticalEdges;
    private int row;
    private int column;

    @Override
    public int[] getBoard() {
        return new int[0];
    }

    @Override
    public int getBoardLength() {
        return 0;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public String[][] getHorizontalEdges() {
        return horizontalEdges;
    }
    public String[][] getVerticalEdges() {
        return verticalEdges;
    }

    public DotsAndBoxesTile(int row, int column) {
        this.row = row;
        this.column = column;
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
}