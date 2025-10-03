package controller;

public interface GameController<M, S> {
    /** Run the full game loop until terminal state or user exits. */
    void run();

    /** Advance one interaction step (render → prompt → read → apply). Useful for tests. */
    boolean step();

    /** Current mutable state (or a facade) so renderers/tests can inspect. */
    S state();

    /** Optional: external input channel (e.g., scripted tests/AI). */
    void onInput(String line);
}