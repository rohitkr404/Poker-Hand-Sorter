package main;

import main.models.Card;
import main.models.Hand;
import main.models.Player;
import main.models.PokerGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // While providing input from console user have to press 'Enter' after a blank line to see the result
                if(line.isBlank())  break;
                String[] cardsArray = line.split(" ");
                List<Card> cards = new ArrayList<>();
                for (String cardString : cardsArray) {
                    Card card = new Card(cardString.charAt(0), cardString.charAt(1));
                    cards.add(card);
                }
                // Ensure that cards have been inputted for both players
                if(cards.size() == 10){
                    player1.setHand(new Hand(cards.subList(0,5)));
                    player2.setHand(new Hand(cards.subList(5,10)));
                }else{
                    System.err.println("Error: Not enough cards provided for both players.");
                    break;
                }
                PokerGame game = new PokerGame(List.of(player1,player2));
                Player winner = game.getWinner();
                winner.setScore(winner.getScore()+1);
            }
            // Output the scores of both players
            System.out.println(player1.getName()+": "+player1.getScore());
            System.out.println(player2.getName()+": "+player2.getScore());
        }       

    }
}