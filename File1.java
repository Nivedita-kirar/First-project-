import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int roundsWon = 0;

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ".");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    roundsWon++;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts. The number was: " + randomNumber);
            }

            System.out.print("Play again? (y/n): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("y");
        }

        System.out.println("Thanks for playing! Rounds won: " + roundsWon);
        scanner.close();
    }
}
