package core;

/**
 * A board square that can hold a {@link Piece}.  Tiles know their row and
 * column coordinates so that game logic can locate neighbors.  A tile may
 * either contain a piece or be empty (in which case {@link #getPiece()} will
 * return {@code null}).  The sliding puzzle uses an empty tile to represent
 * the blank space.
 */
public class Tile {
    private final int row;
    private final int col;
    private Piece piece;

    /**
     * Create a tile at the given coordinates.
     *
     * @param row row index (zero‑based)
     * @param col column index (zero‑based)
     */
    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Get the piece currently occupying this tile.  If no piece is present,
     * {@code null} is returned.
     *
     * @return the piece or {@code null}
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Set a piece on this tile.  Passing {@code null} clears the tile and
     * indicates that it is empty.
     *
     * @param piece the piece to place on the tile
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Whether this tile is empty (i.e., holds no piece or the piece is blank).
     *
     * @return {@code true} if the tile has no piece, otherwise {@code false}
     */
    public boolean isEmpty() {
        return piece == null;
    }

    /**
     * Row index of this tile.
     *
     * @return the row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Column index of this tile.
     *
     * @return the column index
     */
    public int getCol() {
        return col;
    }
}