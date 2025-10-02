package io;

import java.util.List;

public interface Prompter {
    String welcome();
    String askMove();
    String win();
    String errorInvalidMove(List<Integer> validMoves);
    String splitLine();
}
