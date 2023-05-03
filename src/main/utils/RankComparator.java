package main.utils;

import main.Constants.RankConstants;
import main.models.Card;
import main.models.Hand;

import java.util.Comparator;
import java.util.List;

/**
This class implements a Comparator interface to compare two Hands based on their rank and high card.
If the ranks are the same, it compares the high card of both hands to determine the winner.
*/

public class RankComparator implements Comparator<Hand> {

    /**
     Compares two hands based on their rank and high card.    
     @param hand1 the first hand to be compared
     @param hand2 the second hand to be compared
     @return a negative integer, zero, or a positive integer as the first hand is less than, equal to, or greater than the second hand.
    */

    @Override
    public int compare(Hand hand1, Hand hand2) {
        if (hand1 == null || hand2 == null) {
            throw new IllegalArgumentException("Hands cannot be null");
        }
        int rankComparison = hand1.getRank().compareTo(hand2.getRank());
        if (rankComparison != 0) {
            return rankComparison;
        }
        return compareSameRankedHand(hand1, hand2);

    }


    /**
     Compares two hands with the same rank.    
     @param hand1 the first hand to be compared
     @param hand2 the second hand to be compared
     @return a negative integer, zero, or a positive integer as the first hand is less than, equal to, or greater than the second hand.
    */ 

    private int compareSameRankedHand(Hand hand1, Hand hand2){
        switch (hand1.getRank().getRankValue()){
            case RankConstants.PAIR : return compareSamePairedRankedHand(hand1,hand2);
            case RankConstants.TWO_PAIRS: return compareSameTwoPairRankedHand(hand1,hand2);
            case RankConstants.THREE_OF_A_KIND, RankConstants.FULL_HOUSE, RankConstants.FOUR_OF_A_KIND: return compareSameRankedHandCardValue(hand1,hand2);
            default : return compareHighCards(hand1,hand2);
        }
    }


    /**
     Compares two hands with the same rank of two pairs, based on the value of the paired cards and the highest non-paired card.
     @param hand1 the first hand to be compared
     @param hand2 the second hand to be compared
     @return a negative integer, zero, or a positive integer as the first hand is less than, equal to, or greater than the second hand.
     */

    private int compareSameTwoPairRankedHand(Hand hand1, Hand hand2){
        int pairedValueComparison = Integer.compare(hand1.getCards().get(3).getValue(),hand2.getCards().get(3).getValue());
        if( pairedValueComparison != 0){
            return pairedValueComparison;
        }
        pairedValueComparison = Integer.compare(hand1.getCards().get(1).getValue(),hand2.getCards().get(1).getValue());
        if( pairedValueComparison != 0){
            return pairedValueComparison;
        }
        return compareHighCards(hand1,hand2);
    }


    /**

     Compares two hands with the same rank of three of a kind, full house or four of a kind, based on the value of the cards that form the rank.
     @param hand1 the first hand to be compared
     @param hand2 the second hand to be compared
     @return a negative integer, zero, or a positive integer as the first hand is less than, equal to, or greater than the second hand.
     */

    private int compareSameRankedHandCardValue(Hand hand1, Hand hand2){
        int pairedValueComparison = Integer.compare(hand1.getCards().get(2).getValue(),hand2.getCards().get(2).getValue());
        if( pairedValueComparison !=0 ){
            return pairedValueComparison;
        }
        return compareHighCards(hand1,hand2);
    }


    /**
     Compares two hands with the same rank of a pair, based on the value of the paired cards and the highest non-paired card.
     @param hand1 the first hand to be compared
     @param hand2 the second hand to be compared
     @return a negative integer, zero, or a positive integer as the first hand is less than, equal to, or greater than the second hand.
     */    

    private int compareSamePairedRankedHand(Hand hand1, Hand hand2){
        int hand1PairedValue=0;
        int hand2PairedValue=0;
        List<Card> cards1 = hand1.getCards();
        List<Card> cards2 = hand2.getCards();
        for(int i=1;i<cards1.size();i++){
            if(cards1.get(i).getValue() == cards1.get(i-1).getValue()) {
                hand1PairedValue = cards1.get(i).getValue();
            }
        }
        for(int i=1;i<cards2.size();i++){
            if(cards2.get(i).getValue() == cards2.get(i-1).getValue()) {
                hand2PairedValue = cards2.get(i).getValue();
            }
        }
        int pairedValueComparison = Integer.compare(hand1PairedValue,hand2PairedValue);
        if( pairedValueComparison !=0 ){
            return pairedValueComparison;
        }
        return compareHighCards(hand1,hand2);

    }


    /**
     Compares two hands based on their high card.
     @param hand1 the first hand to be compared
     @param hand2 the second hand to be compared
     @return a negative integer, zero, or a positive integer as the first hand is less than, equal to, or greater than the second hand.
     */

    private int compareHighCards(Hand hand1, Hand hand2) {
        List<Card> cards1 = hand1.getCards();
        List<Card> cards2 = hand2.getCards();
        for (int i = cards1.size() - 1; i >= 0; i--) {
            if (cards1.get(i).getValue() < cards2.get(i).getValue()) {
                return -1;
            } else if (cards1.get(i).getValue() > cards2.get(i).getValue()) {
                return 1;
            }
        }
        return 0;
    }
}
