import java.util.Random;
import java.util.Scanner;

public class NumberGuessing2 {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 15;
    private static int roundsWon = 0;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;
        do {
            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
            boolean guessedCorrectly = false;
            int attempts = 0;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + MIN + " and " + MAX + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");
            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) 
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess < MIN || userGuess > MAX) {
                    System.out.println("Please guess a number between " + MIN + " and " + MAX + ".");
                } 
                else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                }
                else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } 
                else
                {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }
            }

            if (!guessedCorrectly) 
            {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            }
            else
            {
                roundsWon++;
            }
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        while (playAgain);
        System.out.println("Thanks for playing! You won " + roundsWon + " rounds.");
        scanner.close();
    }
}
