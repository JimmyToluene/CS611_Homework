package prompt;

import io.GameIO;

public class GameChoicePrompter {
    public String promptGameChoice(GameIO io) {
        while (true) {
            io.println("Please choose a game:");
            io.println("1. Sliding Puzzle (type '1' or 'slide')");
            io.println("2. Dots and Boxes (type '2' or 'dots')");
            
            String choice = io.readLine().trim().toLowerCase();
            
            if (choice.equals("slide") || choice.equals("1")) {
                return "slide";
            } else if (choice.equals("dots") || choice.equals("2")) {
                return "dots";
            } else {
                io.printError("Invalid choice. Please try again.");
            }
        }
    }
}
