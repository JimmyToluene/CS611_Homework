package core;

/**
 * Simple representation of a game participant.  Even games that only involve
 * one human interaction benefit from having a {@code Player} abstraction, as
 * it allows for future expansion to multiplayer or AI opponents.
 */
public class Player {
    private final String name;

    /**
     * Create a new player with a name.
     *
     * @param name human‑readable identifier for the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Retrieve the player's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}