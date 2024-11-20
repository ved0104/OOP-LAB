package lab6_7_8;

import java.util.Random;
import java.util.Scanner;

public class Q7 {
    // Enum to define the game status
    public enum GameStatus {
        CONTINUE, WON, LOST
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Craps game!");
        System.out.print("Press Enter to roll the dice... ");
        input.nextLine();  // Wait for the user to press Enter

        int sumOfDice = rollDice(random);  // Roll the dice for the first time
        GameStatus gameStatus;  // To track the status of the game
        int point = 0;

        switch (sumOfDice) {
            case 7:
            case 11:
                gameStatus = GameStatus.WON;
                break;
            case 2:
            case 3:
            case 12:
                gameStatus = GameStatus.LOST;
                break;
            default:  // Any other value becomes the point
                gameStatus = GameStatus.CONTINUE;
                point = sumOfDice;
                System.out.printf("Your point is: %d\n", point);
                break;
        }

        // Continue rolling if the game is not over
        while (gameStatus == GameStatus.CONTINUE) {
            System.out.print("Press Enter to roll again... ");
            input.nextLine();

            sumOfDice = rollDice(random);

            if (sumOfDice == point) {
                gameStatus = GameStatus.WON;
            } else if (sumOfDice == 7) {
                gameStatus = GameStatus.LOST;
            }
        }

        if (gameStatus == GameStatus.WON) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Sorry, you lost. Better luck next time!");
        }
    }

    // Method to roll the dice and return the sum of two dice
    public static int rollDice(Random random) {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        int sum = die1 + die2;

        System.out.printf("You rolled: %d + %d = %d\n", die1, die2, sum);
        return sum;
    }
}
