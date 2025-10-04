package core;

/**
 * Represents a square game board composed of {@link Tile} objects.  The board
 * maintains a two‑dimensional grid of tiles and exposes basic accessors for
 * retrieving tiles and board size.  Higher‑level game logic should reside in
 * subclasses of {@link Game} rather than in this data structure.
 */
public class Board {
    /**
     * Two‑dimensional array of tiles indexed by row and column.
     */
    protected Tile[][] tiles;

    /**
     * Dimension of the board (board is {@code size}×{@code size}).
     */
    protected int size;

    /**
     * Construct a board of the given dimension.  This constructor allocates
     * space for the tile array but does not populate tiles with pieces; the
     * caller is responsible for creating {@link Tile} objects and setting
     * pieces on them.
     *
     * @param size the dimension (number of rows and columns)
     */
    public Board(int size) {
        this.size = size;
        this.tiles = new Tile[size][size];
    }
    public Board(int row,int column){
        this.size = row*column;
        this.tiles = new Tile[row][column];
    }

    /**
     * Return the tile at the specified row and column.
     *
     * @param row zero‑based row index
     * @param col zero‑based column index
     * @return the {@link Tile} at the specified location
     */
    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    /**
     * Return the dimension of the board.
     *
     * @return the side length of the board
     */
    public int getSize() {
        return size;
    }
}