package tests.utils;
import static org.junit.jupiter.api.Assertions.*;

import main.Constants.RankConstants;
import main.models.Card;
import main.models.Hand;
import main.utils.RankEvaluator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RankEvaluatorTest {

    @Test
    public void testEvaluateRankNullHand() {
        assertThrows(IllegalArgumentException.class, () -> {
            RankEvaluator.evaluateRank(null);
        });
    }

    @Test
    public void testEvaluateRankRoyalFlush() {
        Hand hand = new Hand(createCardList("AD KD QD JD TD"));
        assertEquals(RankConstants.ROYAL_FLUSH, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankStraightFlush() {
        Hand hand = new Hand(createCardList("8D 7D 6D 5D 4D"));
        assertEquals(RankConstants.STRAIGHT_FLUSH, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankFourOfAKind() {
        Hand hand = new Hand(createCardList("AS AC AD AH 7S"));
        assertEquals(RankConstants.FOUR_OF_A_KIND, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankFullHouse() {
        Hand hand = new Hand(createCardList("KS KH KC 2D 2H"));
        assertEquals(RankConstants.FULL_HOUSE, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankFlush() {
        Hand hand = new Hand(createCardList("2C 4C 5C JC QC"));
        assertEquals(RankConstants.FLUSH, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankStraight() {
        Hand hand = new Hand(createCardList("8S 7C 6H 5D 4D"));
        assertEquals(RankConstants.STRAIGHT, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankThreeOfAKind() {
        Hand hand = new Hand(createCardList("4C 4D 4H KS 2C"));
        assertEquals(RankConstants.THREE_OF_A_KIND, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankTwoPairs() {
        Hand hand = new Hand(createCardList("9H 9C 6D 6H AC"));
        assertEquals(RankConstants.TWO_PAIRS, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankPair() {
        Hand hand = new Hand(createCardList("QS QH 8D 7C 2H"));
        assertEquals(RankConstants.PAIR, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testEvaluateRankHighCard() {
        Hand hand = new Hand(createCardList("KD 9C 6D 4H 2S"));
        assertEquals(RankConstants.HIGH_CARD, RankEvaluator.evaluateRank(hand).getRankValue());
    }

    @Test
    public void testIsRoyalFlush() {
        Hand hand = new Hand(createCardList("AD KD QD JD TD"));
        assertTrue(RankEvaluator.isRoyalFlush(hand));
    }

    @Test
    public void testIsNotRoyalFlush() {
        Hand hand = new Hand(createCardList("AS KD QD JD TD"));
        assertFalse(RankEvaluator.isRoyalFlush(hand));
    }

    @Test
    public void testIsStraightFlush() {
        Hand hand = new Hand(createCardList("8D 7D 6D 5D 4D"));
        assertTrue(RankEvaluator.isStraightFlush(hand));
    }

    @Test
    public void testIsNotStraightFlush() {
        Hand hand = new Hand(createCardList("8D 7D 6D 5D 3D"));
        assertFalse(RankEvaluator.isStraightFlush(hand));
    }

    @Test
    public void testIsFourOfAKind() {
        Hand hand = new Hand(createCardList("AS AC AD AH 7S"));
        assertTrue(RankEvaluator.isFourOfAKind(hand));
    }

    private List<Card> createCardList(String cardListString){
        String[] cardsArray = cardListString.split(" ");
        List<Card> cards = new ArrayList<>();
        for (String cardString : cardsArray) {
            Card card = new Card(cardString.charAt(0), cardString.charAt(1));
            cards.add(card);
        }
        return cards;
    }
}

