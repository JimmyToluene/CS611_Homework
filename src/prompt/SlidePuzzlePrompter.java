package prompt;
import java.util.List;
public class SlidePuzzlePrompter implements Prompter{
    public String welcome() { return "🎉 WELCOME TO JIMMY'S SLIDING PUZZLE GAME!! 🎉"; }
    public String askMove() { return "Player, which tile do you want to slide to the empty space?"; }
    public String win()     { return "🥳 YOU WIN!"; }
    public String errorInvalidMove(List<Integer> valid) {
        return "Invalid input. Choose one of: " + valid;
    }
    public String splitLine() { return "-----------------------------------------"; }

    @Override
    public String askBoardSizePrompt() {
        return "Please enter chessboard size (>= 2):";
    }
    public String errorInvalidSize() {
        return "Invalid: Size must be >= 2.";
    }
    public String errorExpectInteger() {
        return "Please enter an integer.";
    }

}
