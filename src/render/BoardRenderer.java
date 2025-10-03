package render;

import io.GameIO;

public interface BoardRenderer <GameBoard>{
    void render(GameBoard board, GameIO io);
}
