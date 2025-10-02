import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

class GameInput {
    private static final Scanner IN = new Scanner(System.in);
    public static int getInput(List<Integer> movableCells) {
        final Scanner in = GameInput.IN;
        while (true) {
            System.out.println("Please enter a number. Valid: " + movableCells);
            String s;
            try {
                s = in.nextLine();            // read full line
            } catch (NoSuchElementException e) {
                System.out.println("No more input. Exiting move.");
                return -1;                       // or break/throw depending on your design
            }

            if (s == null) {                  // very defensive; usually never null
                System.out.println("No input received. Try again.");
                continue;
            }

            s = s.trim();
            if (s.isEmpty()) {
                GamePrompt.printSplitLine();
                System.out.println(GamePrompt.RED+"ERROR INPUT!"+GamePrompt.RESET);
                GamePrompt.printSplitLine();// <-- handles ""
                System.out.println("Empty input. Please type one of: " +GamePrompt.GREEN + movableCells + GamePrompt.RESET);
                continue;
            }

            final int choice;
            try {
                choice = Integer.parseInt(s);// <-- only parse after we know it's non-empty
                if (!movableCells.contains(choice)) {
                    GamePrompt.printSplitLine();
                    System.out.println(GamePrompt.RED+"ERROR INPUT!"+GamePrompt.RESET);
                    GamePrompt.printSplitLine();
                    System.out.println(choice +": That tile is not adjacent. Valid movable elements are:"+GamePrompt.GREEN + movableCells + GamePrompt.RESET);
                    GamePrompt.printSplitLine();
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Please type one of: " + movableCells);
                continue;
            }
        }
    }
}