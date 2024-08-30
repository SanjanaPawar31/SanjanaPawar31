import java.util.Random;
import java.util.Scanner;

public class NumGuessing1 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int numberToGuess = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + min + " and " + max + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");
        while (attempts < maxAttempts) 
        {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            if (userGuess == numberToGuess)
            {
                hasGuessedCorrectly = true;
                break;
            } 
            else if (userGuess < numberToGuess) 
            {
                System.out.println("Too low! Try again.");
            }
            else
            {
                System.out.println("Too high! Try again.");
            }
            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }
        if (hasGuessedCorrectly) 
        {
            System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
        }
        else
        {
            System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess + ".");
        }
        scanner.close();
    }
}
