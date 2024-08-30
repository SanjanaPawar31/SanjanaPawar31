import java.util.Random;
import java.util.Scanner;

public class NumbGuessing 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        boolean playAgain = true;
        while (playAgain)
        {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("Guess the number between " + min + " and " + max + " (You have " + maxAttempts + " attempts):");
            while (attempts < maxAttempts && !hasGuessedCorrectly) 
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == randomNumber)
                {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                }
                else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                }
                else
                {
                    System.out.println("Too high! Try again.");
                }
                if (attempts == maxAttempts && !hasGuessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
                }
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
