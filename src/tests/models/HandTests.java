package tests.models;

import main.Constants.RankConstants;
import main.models.Card;
import main.models.Hand;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HandTests {

    @Test(expected = NullPointerException.class)
    public void testHandConstructorNull() {
        new Hand(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHandConstructorWrongSize() {
        List<Card> cards = Arrays.asList(new Card('A', 'H'), new Card('K', 'H'), new Card('Q', 'H'));
        new Hand(cards);
    }

    @Test
    public void testGetCards() {
        List<Card> cards = Arrays.asList(new Card('A', 'H'), new Card('K', 'H'), new Card('Q', 'H'), new Card('J', 'H'), new Card('T', 'H'));
        Hand hand = new Hand(cards);
        Collections.sort(cards);
        assertEquals(cards, hand.getCards());
    }

    @Test
    public void testGetRank() {
        List<Card> cards = Arrays.asList(new Card('A', 'H'), new Card('K', 'H'), new Card('Q', 'H'), new Card('J', 'H'), new Card('T', 'H'));
        Hand hand = new Hand(cards);
        assertEquals(RankConstants.ROYAL_FLUSH, hand.getRank().getRankValue());
    }

    @Test
    public void testSetRank() {
        List<Card> cards = Arrays.asList(new Card('9', 'H'), new Card('K', 'H'), new Card('Q', 'H'), new Card('J', 'H'), new Card('T', 'H'));
        Hand hand = new Hand(cards);
        assertEquals(RankConstants.STRAIGHT_FLUSH, hand.getRank().getRankValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHasSameCardValueInvalidNumCards() {
        List<Card> cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'S'), new Card('A', 'D'), new Card('K', 'H'), new Card('Q', 'H'));
        Hand hand = new Hand(cards);
        hand.hasSameCardValue(1);
    }

    @Test
    public void testHasSameCardValueTrue() {
        List<Card> cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'S'), new Card('A', 'D'), new Card('K', 'H'), new Card('Q', 'H'));
        Hand hand = new Hand(cards);
        assertTrue(hand.hasSameCardValue(3));
    }

    @Test
    public void testHasSameCardValueFalse() {
        List<Card> cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'S'), new Card('K', 'D'), new Card('K', 'H'), new Card('Q', 'H'));
        Hand hand = new Hand(cards);
        assertFalse(hand.hasSameCardValue(3));
    }

    @Test
    public void testHasTwoDifferentPairsTrue() {
        List<Card> cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'S'), new Card('K', 'D'), new Card('K', 'H'), new Card('Q', 'H'));
        Hand hand = new Hand(cards);
        assertTrue(hand.hasTwoDifferentPairs());
    }

    @Test
    public void testHasTwoDifferentPairsFalse() {
        List<Card> cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'S'), new Card('A', 'D'), new Card('K', 'H'), new Card('Q', 'H'));
        Hand hand = new Hand(cards);
        boolean result = hand.hasTwoDifferentPairs();

        assertFalse(result);
    }
}
