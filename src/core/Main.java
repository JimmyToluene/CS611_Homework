package core;

import io.ConsoleIO;
import io.GameIO;

public class Main {
    public static void main(String[] args) {
        GameIO io = new ConsoleIO();
        GameManager gameManager = new GameManager(io);
        gameManager.startGame();
    }
}
