package io;
import prompt.Prompter;

import java.util.Scanner;

public class ConsoleIO implements GameIO{
    private final Scanner in = new Scanner(System.in);
    public String readLine() {return in.nextLine();}
    public void println(String s) {System.out.println(s);}
    // in SlidePuzzleController (or a small Setup helper the controller calls)
    public int askBoardSize(GameIO io, Prompter p) {
        while (true) {
            io.println(p.askBoardSizePrompt());                      // e.g., "Enter board size (>= 2):"

            String line = io.readLine();
            try {
                int n = Integer.parseInt(line.trim());
                if (n >= 2) return n;
                io.printError(p.errorInvalidSize());          // "Invalid: must be >= 2."
            } catch (NumberFormatException e) {
                io.printError(p.errorExpectInteger());         // "Please enter an integer."
            }
        }
    }

}
