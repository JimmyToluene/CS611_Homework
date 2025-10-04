package core;

import io.GameIO;
import prompt.Prompter;
import render.BoardRenderer;

/**
 * Abstract base class for all games.  A game orchestrates interactions
 * between the board, players, renderer and prompts via the {@link #play()}
 * template method.  Subclasses should implement {@link #initBoard()},
 * {@link #isSolved()} and {@link #move()} to provide game‑specific logic.
 *
 * @param <T> the concrete {@link Board} type used by the game
 */
public abstract class Game<T extends Board> {
    protected final GameIO io;
    protected final Prompter prompter;
    protected final BoardRenderer<T> renderer;
    protected Player[] players;
    protected T board;

    public Game(GameIO io, Prompter prompter, BoardRenderer<T> renderer) {
        this.io = io;
        this.prompter = prompter;
        this.renderer = renderer;
        this.players = new Player[] { new Player("Player 1") };
    }

    /**
     * Initialise the board and set up any starting state.  This method is
     * invoked once at the beginning of {@link #play()}.
     */
    protected abstract void initBoard();

    /**
     * Return {@code true} when the game has reached its terminal state.  For
     * example, the sliding puzzle is solved when all tiles are in order.
     *
     * @return whether the game is solved
     */
    protected abstract boolean isSolved();

    /**
     * Perform one move of game play, including any prompting of the user for
     * input and applying state changes.  This method is called repeatedly
     * until {@link #isSolved()} returns {@code true}.
     */
    protected abstract void move();

    /**
     * Template method to run the game.  Subclasses should not override this
     * method; instead, they customise the behaviour via {@link #initBoard()},
     * {@link #isSolved()} and {@link #move()}.
     */
    public final void play() {
        initBoard();
        io.println(prompter.welcome());
        while (!isSolved()) {
            renderer.render(board, io);
            move();
            io.println(prompter.splitLine());
        }
        renderer.render(board, io);
        io.println(prompter.win());
    }
}