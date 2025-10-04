package core;

import io.ConsoleIO;
import io.GameIO;
import prompt.GameChoicePrompter;
import prompt.Prompter;
import prompt.SlidePuzzlePrompter;
import render.ConsoleBoardRenderer;

/**
 * High‑level coordinator that selects which game to run based on user
 * input.  It decouples game selection and initialisation from the
 * implementations themselves.
 */
public class GameManager {
    private final GameIO io;

    public GameManager(GameIO io) {
        this.io = io;
    }

    /**
     * Present a menu of games and start the chosen one.
     */
    public void startGame() {
        GameChoicePrompter chooser = new GameChoicePrompter();
        String choice = chooser.promptGameChoice(io);
        if (choice.equals("slide")) {
            startSlidingPuzzle();
        } else if (choice.equals("dots")) {
            startDotsAndBoxes();
        }
    }

    /**
     * Initialise and run the sliding puzzle using the new game architecture.
     */
    private void startSlidingPuzzle() {
        Prompter prompter = new SlidePuzzlePrompter();
        // ask for board size; cast to ConsoleIO to access askBoardSize helper
        int size = ((ConsoleIO) io).askBoardSize(io, prompter);
        SlidingPuzzleGame game = new SlidingPuzzleGame(io, prompter,
                new ConsoleBoardRenderer(), size, 20);
        game.play();
    }

    /**
     * Placeholder for future Dots and Boxes implementation.
     */
    private void startDotsAndBoxes() {
        io.println("Dots and Boxes game is not yet implemented.");
    }
}