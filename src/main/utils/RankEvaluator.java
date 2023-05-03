package main.utils;

import main.models.RankModels.*;
import main.models.Hand;

/**
This class is responsible for evaluating the rank of a given Hand object, starting from the highest possible rank.
*/
public class RankEvaluator {

    /**
     This method takes a Hand object as input and returns a Rank object based on the highest possible rank that the hand can have.
     */
    public static Rank evaluateRank(Hand hand) {
        if (hand == null) {
            throw new IllegalArgumentException("Hand object cannot be null");
        }
        if (isRoyalFlush(hand)) {
            return new RoyalFlushRank();
        } else if (isStraightFlush(hand)) {
            return new StraightFlushRank();
        } else if (isFourOfAKind(hand)) {
            return new FourOfAKindRank();
        } else if (isFullHouse(hand)) {
            return new FullHouseRank();
        } else if (isFlush(hand)) {
            return new FlushRank();
        } else if (isStraight(hand)) {
            return new StraightRank();
        } else if (isThreeOfAKind(hand)) {
            return new ThreeOfAKindRank();
        } else if (isTwoPairs(hand)) {
            return new TwoPairsRank();
        } else if (isPair(hand)) {
            return new PairRank();
        } else {
            return new HighCardRank();
        }
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is a Royal Flush or not.
     */
    public static boolean isRoyalFlush(Hand hand) {

        return isStraightFlush(hand) && hand.hasCardValue(14);
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is a Straight Flush or not.
     */
    public static boolean isStraightFlush(Hand hand) {

        return isFlush(hand) && isStraight(hand);
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is a Four of a Kind or not.
     */
    public static boolean isFourOfAKind(Hand hand) {

        return hand.hasSameCardValue(4);
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is a Full House or not.
     */
    public static boolean isFullHouse(Hand hand) {

        return hand.hasThreeOfAKindAndAPair();
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is a Flush or not.
     */
    public static boolean isFlush(Hand hand) {
        return hand.hasSameCardSuit();
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is a Straight or not.
     */
    public static boolean isStraight(Hand hand) {

        return hand.hasStraight();
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is a Three of a Kind or not.
     */
    public static boolean isThreeOfAKind(Hand hand) {

        return hand.hasSameCardValue(3);
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is Two Pairs or not.
     */
    public static boolean isTwoPairs(Hand hand) {

        return hand.hasTwoDifferentPairs();
    }

    /**
     This method takes a Hand object as input and returns a boolean value indicating whether the hand is a Pair or not.
     */
    public static boolean isPair(Hand hand) {

        return hand.hasSameCardValue(2);
    }

}
