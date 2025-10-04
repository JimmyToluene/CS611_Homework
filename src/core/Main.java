package core;

import io.ConsoleIO;
import io.GameIO;

/**
 * Entry point for running the CS611 homework games.  Instantiates a
 * {@link GameManager} and passes a console I/O implementation to it.
 */
public class Main {
    public static void main(String[] args) {
        GameIO io = new ConsoleIO();
        GameManager manager = new GameManager(io);
        manager.startGame();
    }
}