package core;

import controller.GameController;
import controller.SlidePuzzleController;
import io.GameIO;
import prompt.GameChoicePrompter;
import prompt.Prompter;
import prompt.SlidePuzzlePrompter;
import prompt.DotsBoxesPrompter;
import render.BoardRenderer;
import render.ConsoleSlidePuzzleRenderer;

public class GameManager {
    private final GameIO io;

    public GameManager(GameIO io) {
        this.io = io;
    }

    public void startGame() {
        GameChoicePrompter gameChoicePrompter = new GameChoicePrompter();
        String gameChoice = gameChoicePrompter.promptGameChoice(io);
        
        if (gameChoice.equalsIgnoreCase("slide")) {
            startSlidePuzzle();
        } else if (gameChoice.equalsIgnoreCase("dots")) {
            startDotsAndBoxes();
        }
    }

    private void startSlidePuzzle() {
        Prompter prompts = new SlidePuzzlePrompter();
        BoardRenderer<SlidePuzzleBoard> renderer = new ConsoleSlidePuzzleRenderer();
        SlidePuzzleController controller = new SlidePuzzleController(io, prompts, renderer);
        SlidePuzzleBoard board = new SlidePuzzleBoard(SlidePuzzleBoard.getBoardSize(), 20);
        controller.run(board);
    }

    private void startDotsAndBoxes() {
        Prompter prompts = new DotsBoxesPrompter();
        io.println("Dots and Boxes game is not yet implemented");
    }
}