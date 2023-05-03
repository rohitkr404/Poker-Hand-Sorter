package tests.models;

import main.models.Card;
import main.models.Hand;
import main.models.Player;
import main.models.PokerGame;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class PokerGameTests {

    @Test
    public void testGetWinner() {
        // create players and their hands
        Player john = new Player("John");
        Hand johnHand = new Hand(Arrays.asList(
                new Card('2', 'H'),
                new Card('3', 'D'),
                new Card('4', 'S'),
                new Card('5', 'C'),
                new Card('6', 'H')
        ));
        john.setHand(johnHand);

        Player alice = new Player("Alice");
        Hand aliceHand = new Hand(Arrays.asList(
                new Card('2', 'D'),
                new Card('3', 'H'),
                new Card('4', 'D'),
                new Card('5', 'H'),
                new Card('6', 'D')
        ));
        alice.setHand(aliceHand);

        List<Player> players = Arrays.asList(john, alice);

        // create PokerGame with players
        PokerGame game = new PokerGame(players);

        // check winner
        Player winner = game.getWinner();
        assertNotNull(winner);
        System.out.println(johnHand.getRank().getDescription());
        System.out.println(aliceHand.getRank().getDescription());
        assertEquals("John", winner.getName());
    }

    @Test
    public void testGetWinnerWithTie() {
        // create players and their hands
        Player alice = new Player("Alice");
        Hand aliceHand = new Hand(Arrays.asList(
                new Card('2', 'D'),
                new Card('3', 'H'),
                new Card('4', 'D'),
                new Card('5', 'H'),
                new Card('6', 'D')
        ));
        alice.setHand(aliceHand);

        Player bob = new Player("Bob");
        Hand bobHand = new Hand(Arrays.asList(
                new Card('2', 'C'),
                new Card('3', 'S'),
                new Card('4', 'C'),
                new Card('5', 'D'),
                new Card('6', 'C')
        ));
        bob.setHand(bobHand);

        List<Player> players = Arrays.asList(alice, bob);

        // create PokerGame with players
        PokerGame game = new PokerGame(players);

        // check winner
        Player winner = game.getWinner();
        assertNotNull(winner);
        assertEquals("Alice", winner.getName());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetWinnerWithNoPlayers() {
        // create empty players list
        List<Player> players = Arrays.asList();

        // create PokerGame with empty players list
        PokerGame game = new PokerGame(players);

        // try to get winner
        game.getWinner();
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullPlayers() {
        new PokerGame(null);
    }

}

