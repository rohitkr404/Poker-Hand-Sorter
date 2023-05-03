package main.models;

/**
 * This class represents a player in a poker game. Each player has a name, a hand of 5 cards, and a score.
 * The score is an integer value that keeps track of the player's points.
 */
public class Player {
    private String name;
    private Hand hand;
    private int score = 0;

    public Player(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        if (hand == null) {
            throw new IllegalArgumentException("Hand cannot be null.");
        }
        this.hand = hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
