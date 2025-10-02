package io;

public interface GameIO {
    String readLine(); //raw input(one line)
    void println(String s);//with newline print
    default void printError(String s) { println(s); }
}
