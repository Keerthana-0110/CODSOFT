import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int bestScore = 0;
        boolean playAgain = true;

        System.out.println("======================================");
        System.out.println("      WELCOME TO THE NUMBER GAME      ");
        System.out.println("======================================");

        while (playAgain) {
            int maxNumber = 100;
            int attempts = 7;

            System.out.println("\nChoose Difficulty Level:");
            System.out.println("1. Easy (1 to 50, 4 attempts)");
            System.out.println("2. Medium (1 to 100, 7 attempts)");
            System.out.println("3. Hard (1 to 200, 5 attempts)");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    maxNumber = 50;
                    attempts = 4;
                    break;
                case 2:
                    maxNumber = 100;
                    attempts = 7;
                    break;
                case 3:
                    maxNumber = 200;
                    attempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice! Medium level selected by default.");
                    maxNumber = 100;
                    attempts = 7;
            }

            int secretNumber = random.nextInt(maxNumber) + 1;
            boolean guessedCorrectly = false;

            System.out.println("\nI have chosen a number between 1 and " + maxNumber + ".");
            System.out.println("Try to guess it!");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == secretNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (guessedCorrectly) {
                int score = attempts * 10;
                System.out.println("\nCongratulations! You guessed the correct number.");
                System.out.println("Your score: " + score);

                if (score > bestScore) {
                    bestScore = score;
                    System.out.println("New Best Score!");
                }
            } else {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("Best Score So Far: " + bestScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = sc.next();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThank you for playing!");
        sc.close();
    }
}