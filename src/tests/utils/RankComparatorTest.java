package tests.utils;

import main.models.Card;
import main.models.Hand;
import main.utils.RankComparator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RankComparatorTest {

    @Test
    public void testCompareSameRankAndHighCard() {
        Hand hand1 = new Hand(Arrays.asList(
                new Card('2', 'H'),
                new Card('3', 'C'),
                new Card('4', 'D'),
                new Card('5', 'S'),
                new Card('6', 'H')));
        Hand hand2 = new Hand(Arrays.asList(new Card('2', 'D'),
                new Card('3', 'H'),
                new Card('4', 'C'),
                new Card('5', 'H'),
                new Card('6', 'D')));
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2),0);
    }

    @Test
    public void testCompareHigherRank() {
        Hand hand1 = new Hand(Arrays.asList(new Card('2', 'H'), new Card('2', 'C'), new Card('2', 'D'), new Card('3', 'S'), new Card('4', 'H'))); // three of a kind twos
        Hand hand2 = new Hand(Arrays.asList(new Card('T', 'H'), new Card('T', 'C'), new Card('T', 'S'), new Card('5', 'H'), new Card('6', 'D'))); // three of a kind tens
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2),-1);
    }

    @Test
    public void testCompareLowerRank() {
        Hand hand1 = new Hand(Arrays.asList(new Card('2', 'D'), new Card('2', 'S'), new Card('4', 'C'), new Card('4', 'H'), new Card('5', 'D'))); // two pairs of twos and fours
        Hand hand2 = new Hand(Arrays.asList(new Card('2', 'H'), new Card('2', 'C'), new Card('3', 'D'), new Card('3', 'S'), new Card('4', 'H'))); // two pairs of twos and threes
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2),1);
    }


    @Test
    public void testCompareSameRankedHandSameHighCard() {
        Hand hand1 = new Hand(Arrays.asList(new Card('2', 'H'), new Card('3', 'C'), new Card('4', 'D'), new Card('5', 'S'), new Card('6', 'H')));
        Hand hand2 = new Hand(Arrays.asList(new Card('2', 'D'), new Card('3', 'H'), new Card('4', 'C'), new Card('5', 'H'), new Card('6', 'S')));
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2),0);
    }

    @Test
    public void testCompareSameRankedHand() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('K', 'S'), new Card('Q', 'D'), new Card('J', 'C'), new Card('9', 'H'));
        List<Card> hand2Cards = Arrays.asList(new Card('A', 'D'), new Card('K', 'H'), new Card('Q', 'S'), new Card('J', 'D'), new Card('9', 'S'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = new Hand(hand2Cards);
        int result = hand1.getRank().compareTo(hand2.getRank());
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2),0);
    }


    @Test
    public void testCompareSameTwoPairRankedHandEqual() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'D'), new Card('K', 'H'), new Card('K', 'D'), new Card('5', 'C'));
        List<Card> hand2Cards = Arrays.asList(new Card('A', 'S'), new Card('A', 'C'), new Card('K', 'S'), new Card('K', 'C'), new Card('5', 'D'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = new Hand(hand2Cards);
        int result = hand1.getRank().compareTo(hand2.getRank());
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2),0);
    }

    @Test
    public void testCompareSameTwoPairRankedHand() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'D'), new Card('K', 'H'), new Card('K', 'D'), new Card('J', 'C'));
        List<Card> hand2Cards = Arrays.asList(new Card('A', 'S'), new Card('A', 'C'), new Card('K', 'S'), new Card('K', 'C'), new Card('9', 'D'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = new Hand(hand2Cards);
        int result = hand1.getRank().compareTo(hand2.getRank());
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2),1);
    }

    @Test
    public void testCompareSameRankedHandCardValueReturnsZero() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('K', 'D'), new Card('Q', 'C'), new Card('J', 'S'), new Card('T', 'H'));
        List<Card> hand2Cards = Arrays.asList(new Card('A', 'D'), new Card('K', 'C'), new Card('Q', 'S'), new Card('J', 'H'), new Card('T', 'D'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = new Hand(hand2Cards);
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1, hand2), 0);
    }

    @Test
    public void testCompareSameRankedHandCardValueReturnsPositiveInteger() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('K', 'D'), new Card('Q', 'C'), new Card('J', 'S'), new Card('T', 'H'));
        List<Card> hand2Cards = Arrays.asList(new Card('K', 'C'), new Card('J', 'H'), new Card('T', 'D'), new Card('9', 'S'), new Card('8', 'H'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = new Hand(hand2Cards);
        RankComparator rankComparator = new RankComparator();
        assertTrue(rankComparator.compare(hand1, hand2) > 0);
    }

    @Test
    public void testCompareSamePairedRankedHandReturnsZero() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'D'), new Card('K', 'C'), new Card('Q', 'S'), new Card('T', 'H'));
        List<Card> hand2Cards = Arrays.asList(new Card('A', 'S'), new Card('A', 'C'), new Card('K', 'S'), new Card('Q', 'H'), new Card('T', 'D'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = new Hand(hand2Cards);
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1, hand2), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareSamePairedRankedHandThrowsIllegalArgumentException() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'D'), new Card('K', 'C'), new Card('Q', 'S'), new Card('J', 'H'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = null;
        RankComparator rankComparator = new RankComparator();
        rankComparator.compare(hand1,hand2);
    }

    @Test
    public void testCompareSamePairedRankedHandReturns0() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('A', 'D'), new Card('K', 'C'), new Card('Q', 'S'), new Card('J', 'H'));
        List<Card> hand2Cards = Arrays.asList(new Card('A', 'S'), new Card('A', 'C'), new Card('K', 'D'), new Card('Q', 'C'), new Card('J', 'S'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = new Hand(hand2Cards);
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2), 0);
    }

    @Test
    public void testCompareHighCardsReturns0() {
        List<Card> hand1Cards = Arrays.asList(new Card('A', 'H'), new Card('K', 'D'), new Card('Q', 'C'), new Card('J', 'S'), new Card('T', 'H'));
        List<Card> hand2Cards = Arrays.asList(new Card('A', 'D'), new Card('K', 'H'), new Card('Q', 'S'), new Card('J', 'C'), new Card('T', 'D'));
        Hand hand1 = new Hand(hand1Cards);
        Hand hand2 = new Hand(hand2Cards);
        RankComparator rankComparator = new RankComparator();
        assertEquals(rankComparator.compare(hand1,hand2), 0);
    }


}
