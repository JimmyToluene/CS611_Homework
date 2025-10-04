package core;

abstract class GameTile {
    protected int[] board;
    protected int length;

    abstract public int[] getBoard();
    abstract public int getBoardLength();
}
