package tests.models;

import org.junit.Test;
import main.models.Card;

import static org.junit.Assert.*;

public class CardTests {

    @Test
    public void testConstructorValidArguments() {
        Card card = new Card('2', 'H');
        assertEquals(2, card.getValue());
        assertEquals('H', card.getSuit());
    }

    @Test
    public void testConstructorInvalidValueArgument() {
        assertThrows(IllegalArgumentException.class, () -> new Card('X', 'S'));
    }

    @Test
    public void testConstructorInvalidSuitArgument() {
        assertThrows(IllegalArgumentException.class, () -> new Card('K', '\u0000'));
    }

    @Test
    public void testCompareToLessThan() {
        Card card1 = new Card('4', 'S');
        Card card2 = new Card('Q', 'D');
        assertTrue(card1.compareTo(card2) < 0);
    }

    @Test
    public void testCompareToGreaterThan() {
        Card card1 = new Card('A', 'H');
        Card card2 = new Card('J', 'C');
        assertTrue(card1.compareTo(card2) > 0);
    }

    @Test
    public void testCompareToEquals() {
        Card card1 = new Card('K', 'D');
        Card card2 = new Card('K', 'H');
        assertEquals(0, card1.compareTo(card2));
    }

    @Test
    public void testCompareToNull() {
        Card card = new Card('7', 'C');
        assertThrows(NullPointerException.class, () -> card.compareTo(null));
    }
}

