# Poker Hands Assessment

## Prerequisite:
- Java 15 or later

## How to Compile and Execute:
1. Clone the repository
2. Navigate to the root directory of the project
3. Compile the code using the command `javac -d bin/ src/main/models/RankModels/*.java src/main/models/*.java src/main/Constants/*.java src/main/utils/*.java src/main/*.java`
4. Create the jar file using the command `jar cvfm PokerHandSorter.jar Manifest.txt -C bin/ .`
5. Run the program using the command `cat poker-hands.txt | java -jar PokerHandSorter.jar`

## Input:
The input for this program should be a text file containing multiple lines, each line representing a poker hand with 5 cards for each player. The cards should be represented in the following format:
- Rank of the card: A (Ace), 2, 3, 4, 5, 6, 7, 8, 9, T (Ten), J (Jack), Q (Queen), K (King)
- Suit of the card: C (Clubs), D (Diamonds), H (Hearts), S (Spades)

Example:
```
4H 4C 6S 7S KD 2C 3S 9S 9D TD
5D 8C 9S JS AC 2C 5C 7D 8S QH
2D 9C AS AH AC 3D 6D 7D TD QD
4D 6S 9H QH QC 3D 6D 7H QD QS
2H 2D 4C 4D 4S 3C 3D 3S 9S 9D 
```

## Output:
The output of this program will be the winner of each hand:

```
Player 1: 3
Player 2: 2
```

## Note:
1. While providing input from console user have to press 'Enter' after a blank line to see the result.
2. This program does not handle ties like when both player have same rank from different suit. In such tie scenario player1 is considered winner.