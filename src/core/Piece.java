package core;

/**
 * Represents a physical piece that occupies a {@link Tile}.  A piece
 * encapsulates an integer value used by the sliding puzzle to determine
 * ordering.  A value of {@code 0} signifies the blank piece (empty space).
 */
public class Piece {
    private final int value;

    /**
     * Create a new piece with the given value.
     *
     * @param value numeric value (0 represents the blank tile)
     */
    public Piece(int value) {
        this.value = value;
    }

    /**
     * The numeric value of this piece.  For sliding puzzles, non‑zero values
     * represent tiles labelled 1 through N‑1.  A value of zero indicates the
     * blank tile.
     *
     * @return the piece's value
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value == 0 ? " " : Integer.toString(value);
    }
}