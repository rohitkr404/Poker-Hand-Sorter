package main.models;

import main.utils.RankComparator;

import java.util.List;
import java.util.Objects;

/**
 This class represents a poker game with a list of players.
 */
public class PokerGame {
    private List<Player> players;

    /**
     Constructs a PokerGame with a list of players.
     @param players list of players in the game
     @throws IllegalArgumentException if players list is null
     */
    public PokerGame(List<Player> players) {
        this.players = Objects.requireNonNull(players, "players list cannot be null");
    }

    
    /**
     Returns the player with the best hand among all the players in the game.
     Note : when both player have same rank from different suit. In such tie scenario player1 is considered winner.
     @return the player with the best hand
     @throws IllegalStateException if players list is empty
     */
    public Player getWinner() {
        if (players.isEmpty()) {
            throw new IllegalStateException("players list cannot be empty");
        }
        Player bestHandPlayer = players.get(0);
        RankComparator comparator = new RankComparator();
        for (int i=1; i < players.size(); i++) {
            if ( comparator.compare(bestHandPlayer.getHand(),players.get(i).getHand()) < 0 ) {
                bestHandPlayer = players.get(i);
            }
        }
        return bestHandPlayer;
    }
}
