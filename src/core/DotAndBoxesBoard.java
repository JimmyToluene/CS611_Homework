package core;

public class DotAndBoxesBoard extends Board{
    private final int rows;
    private final int cols;
    private final Board horizEdges; // (rows + 1) x cols
    private final Board vertEdges;  // rows x (cols + 1)
    private final int[][] boxOwners;      // rows x cols


    public DotAndBoxesBoard(int rows, int cols) {
        super(rows,cols);
        this.rows = rows;
        this.cols = cols;
        this.horizEdges = new Board(rows-1,cols);
        this.vertEdges = new Board(rows,cols-1);
        this.boxOwners = new int[rows-1][cols-1];
    }
}

