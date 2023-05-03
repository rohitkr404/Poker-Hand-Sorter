package main.Constants;

/**
 This class is a utils class that defines constant values for each of the possible ranks in a poker game. 
 These constants represent the rank values and descriptions of rank of a hand. 
 */

public class RankConstants {
    public static final int HIGH_CARD = 1;
    public static final int PAIR = 2;
    public static final int TWO_PAIRS = 3;
    public static final int THREE_OF_A_KIND = 4;
    public static final int STRAIGHT = 5;
    public static final int FLUSH = 6;
    public static final int FULL_HOUSE = 7;
    public static final int FOUR_OF_A_KIND = 8;
    public static final int STRAIGHT_FLUSH = 9;
    public static final int ROYAL_FLUSH = 10;

    public static final String HIGH_CARD_DESC = "Highest value card";
    public static final String PAIR_DESC = "Two cards of same value";
    public static final String TWO_PAIRS_DESC = "Two different pairs";
    public static final String THREE_OF_A_KIND_DESC = "Three cards of the same value";
    public static final String STRAIGHT_DESC = "All five cards in consecutive value order";
    public static final String FLUSH_DESC = "All five cards having the same suit";
    public static final String FULL_HOUSE_DESC = "Three of a kind and a Pair";
    public static final String FOUR_OF_A_KIND_DESC = "Four cards of the same value";
    public static final String STRAIGHT_FLUSH_DESC = "All five cards in consecutive value order, with the same suit";
    public static final String ROYAL_FLUSH_DESC = "Ten, Jack, Queen, King and Ace in the same suit";
}
