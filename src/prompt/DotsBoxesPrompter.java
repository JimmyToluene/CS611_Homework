package prompt;
import java.util.List;
public class DotsBoxesPrompter implements Prompter{
    public String welcome() { return "🎉 WELCOME TO JIMMY AND DANNY'S DOTS AND BOXES PUZZLE GAME!! 🎉"; }
    public String askMove() { return "Player, where would you like to draw a line?"; }
    public String win()     { return "🥳 YOU WIN!"; }
    public String errorInvalidMove(List<Integer> valid) {
        return "Invalid input. Choose one of: " + valid;
    }
    public String splitLine() { return "-----------------------------------------"; }

    @Override
    public String askBoardSizePrompt() {
        return "Please enter board size (>= 2):";
    }
    public String errorInvalidSize() {
        return "Invalid: Size must be >= 2.";
    }
    public String errorExpectInteger() {
        return "Please enter an integer.";
    }

}