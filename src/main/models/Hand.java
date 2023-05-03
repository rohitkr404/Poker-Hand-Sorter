package main.models;

import main.models.RankModels.Rank;
import main.utils.RankEvaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 This class represents a hand of a player in a poker game, consisting of five cards. The class includes methods for determining the
 rank of the hand and for checking whether the hand contains certain combinations of cards, such as a pair or a straight.
 */
public class Hand {
    private List<Card> cards;

    private Rank rank;


    /**
     Constructs a hand with the given list of cards. The constructor throws an IllegalArgumentException if the list
     does not contain exactly five cards. The constructor sorts the cards in ascending order and evaluates the rank of
     the hand using the RankEvaluator class.
     @param cards a list of five cards representing the hand
     @throws IllegalArgumentException if the list does not contain exactly five cards
     */
    
    public Hand(List<Card> cards) {
        if (cards == null) {
            throw new NullPointerException("Hand cannot be null.");
        }
        if (cards.size() != 5) {
            throw new IllegalArgumentException("Hand must have exactly 5 cards.");
        }
        this.cards = new ArrayList<>(cards);
        Collections.sort(this.cards);
        rank = RankEvaluator.evaluateRank(this);
    }

    /**
     Returns the list of cards in the hand.
     @return a list of five cards representing the hand
     */

    public List<Card> getCards() {
        return cards;
    }


    /**
     Returns the rank of the hand, as determined by the RankEvaluator class.
     @return the rank of the hand
     */

    public Rank getRank() {

        return rank;
    }


    /**
     Sets the rank of the hand.
     @param rank the new rank of the hand
     */

    public void setRank(Rank rank) {

        this.rank = rank;
    }


    /**
     Returns true if the hand contains a group of cards with the same value, where the size of the group is equal to the
     given number of cards. The method throws an IllegalArgumentException if the given number of cards is less than 2
     or greater than 5.
     @param numCards the number of cards in the group to check for
     @return true if the hand contains a group of cards with the same value and size numCards, false otherwise
     @throws IllegalArgumentException if the given number of cards is less than 2 or greater than 5
     */
    public boolean hasSameCardValue(int numCards) {
        if (numCards < 2 || numCards > 5) {
            throw new IllegalArgumentException("Invalid number of cards.");
        }
        for (int i = 0; i <= (5-numCards); i++) {
            boolean isSameCardValue = true;
            int value = cards.get(i).getValue();
            for(int j = i+1; j < (i+numCards); j++){
                if(cards.get(j).getValue() != value){
                    isSameCardValue = false;
                    break;
                }
            }
            if(isSameCardValue) return true;
        }
        return false;
    }

    /**
     Returns true if the hand contains two different pairs of cards with the same value.
     @return true if the hand contains two different pairs of cards with the same value, false otherwise
     */
    public boolean hasTwoDifferentPairs(){
        if( ( cards.get(0).getValue() == cards.get(1).getValue() && ( cards.get(2).getValue() == cards.get(3).getValue() || cards.get(3).getValue() == cards.get(4).getValue() ) )
          || ( cards.get(1).getValue() == cards.get(2).getValue() && cards.get(3).getValue() == cards.get(4).getValue() ) ){
            return true;
        }
        return false;
    }

    /**
     Returns true if the hand contains three of a kind and a pair of cards with the same value.
     @return true if the hand contains three of a kind and a pair of cards with the same value, false otherwise
     */

    public boolean hasThreeOfAKindAndAPair(){
        if( ( cards.get(0).getValue() == cards.get(1).getValue() && cards.get(1).getValue() == cards.get(2).getValue() && cards.get(3).getValue() == cards.get(4).getValue() )
         || ( cards.get(0).getValue() == cards.get(1).getValue() && cards.get(2).getValue() == cards.get(3).getValue() && cards.get(3).getValue() == cards.get(4).getValue() ) ){
            return true;
        }
        return false;
    }

    /**
     Returns true if the hand contains a card with the given value.
     @param value the value of the card to check for
     @return true if the hand contains a card with the given value, false otherwise
     */
    public boolean hasCardValue(int value) {
        for (Card card : cards) {
            if (card.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     Returns true if all cards in the hand have the same suit.
     @return true if all cards in the hand have the same suit, false otherwise
     */
    public boolean hasSameCardSuit() {
        char suit = cards.get(0).getSuit();
        for (int i = 1; i < 5; i++) {
            if (cards.get(i).getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    /**
     Returns true if the hand contains a straight, where the cards are in sequential order (e.g., 2-3-4-5-6 or 10-J-Q-K-A).
     @return true if the hand contains a straight, false otherwise
     */
    public boolean hasStraight(){
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getValue() - cards.get(i).getValue() != 1) {
                return false;
            }
        }
        return true;
    }

}

