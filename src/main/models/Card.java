package main.models;

/**
This class represents a card with a value and a suit,
and it implements the Comparable interface to enable comparison between different cards based on their values
*/

public class Card implements Comparable<Card> {
    private int value;
    private char suit;

    public Card(char value, char suit) {
        if (value == '\u0000' || suit == '\u0000') {
            throw new IllegalArgumentException("Invalid arguments: value or suit cannot be null");
        }
        switch (value) {
            case '2':
                this.value = 2;
                break;
            case '3':
                this.value = 3;
                break;
            case '4':
                this.value = 4;
                break;
            case '5':
                this.value = 5;
                break;
            case '6':
                this.value = 6;
                break;
            case '7':
                this.value = 7;
                break;
            case '8':
                this.value = 8;
                break;
            case '9':
                this.value = 9;
                break;
            case 'T':
                this.value = 10;
                break;
            case 'J':
                this.value = 11;
                break;
            case 'Q':
                this.value = 12;
                break;
            case 'K':
                this.value = 13;
                break;
            case 'A':
                this.value = 14;
                break;
            default:
                throw new IllegalArgumentException("Invalid card value: " + value);
        }
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare with null object");
        }
        return Integer.compare(value, other.value);
    }
}
