package tests.models;

import main.models.Card;
import main.models.Hand;
import main.models.Player;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlayerTests {

    @Test
    public void testConstructor() {
        String name = "John";
        Player player = new Player(name);
        assertEquals(name, player.getName());
        assertNull(player.getHand());
        assertEquals(0, player.getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullName() {
        new Player(null);
    }

    @Test
    public void testSetHand() {
        Player player = new Player("John");
        Hand hand = new Hand(Arrays.asList(new Card('A', 'H'), new Card('K', 'S'), new Card('Q', 'D'), new Card('J', 'C'), new Card('T', 'S')));
        player.setHand(hand);
        assertEquals(hand, player.getHand());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHandWithNull() {
        Player player = new Player("John");
        player.setHand(null);
    }

    @Test
    public void testSetScore() {
        Player player = new Player("John");
        int score = 10;
        player.setScore(score);
        assertEquals(score, player.getScore());
    }

}
