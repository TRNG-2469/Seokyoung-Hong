import java.awt.datatransfer.SystemFlavorMap;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    //Step 1: Creating the class
    public static void main(String[] args) {

        //Step 2: Generating a target / initializing loop
        int targetNumber = (int) (Math.random() * 50) + 1;
        int maxAttempts = 5;
        int attemptCount = 0;
        boolean hasGuessedCorrectly = false;

        Scanner scanner = new Scanner(System.in);

        //Step 3: Implementing Game Loop Logic
        while (attemptCount < maxAttempts && !hasGuessedCorrectly) {
            attemptCount++;
            System.out.print("Attempt [" + attemptCount + "/5] - Enter your guess: ");
            int guess = Integer.parseInt(scanner.nextLine());

            if (guess < 1 || guess > 50) {
                System.out.println("Warning! Guess is out of range!");
                attemptCount--;
                continue;
            }

            if (guess == targetNumber) {
                hasGuessedCorrectly = true;
                break;
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }

        //Step 4: Handle end of game
        scanner.close();

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the secret number!");
        } else {
            System.out.println("Game over! You've run out of attempts. The secret number was " + targetNumber);
        }

    }
}
