package core;

import controller.SlidePuzzleController;
import io.ConsoleIO;
import io.GameIO;
import prompt.Prompter;
import prompt.SlidePuzzlePrompter;
import render.BoardRenderer;
import render.ConsoleSlidePuzzleRenderer;


public class Main {
    public static void main(String[] args) {
        GameIO io = new ConsoleIO();
        Prompter prompts = new SlidePuzzlePrompter();
        BoardRenderer<SlidePuzzleBoard> renderer = new ConsoleSlidePuzzleRenderer();
        SlidePuzzleController controller = new SlidePuzzleController(io, prompts, renderer);
        SlidePuzzleBoard board = new SlidePuzzleBoard(/*n*/ SlidePuzzleBoard.getBoardSize(), /*steps*/ 20);
        controller.run(board);

    }
}

