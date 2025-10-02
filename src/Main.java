import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        GamePrompt slidepuzzlePrompt = new GamePrompt();
        slidepuzzlePrompt.setWelcomePrompt("\uD83C\uDF89 WELCOME TO JIMMY'S SLIDING PUZZLE GAME!! \uD83C\uDF89");
        slidepuzzlePrompt.setAskNextMovePrompt("Player, which tile do you want to slide to the empty space?");
        slidepuzzlePrompt.setWinPrompt("\uD83E\uDD73 YOU WIN!");
        GamePrompt.printSplitLine();
        slidepuzzlePrompt.printWelcomePrompt();
        GamePrompt.printSplitLine();
        SlidingPuzzleBoard slidePuzzleBoard = new SlidingPuzzleBoard(SlidingPuzzleBoard.getBoardSize(),20);


        // Main loop of playing Game
        while(!Arrays.equals(slidePuzzleBoard.getBoard(), slidePuzzleBoard.getTargetBoard())) {
            GameActions.playSlidePuzzle(slidePuzzleBoard);
        }
        slidepuzzlePrompt.printWinPrompt();
    }
}