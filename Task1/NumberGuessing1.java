import java.util.Random;
import java.util.Scanner;

public class NumberGuessing1 {
    public static void main(String[] args)
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;   
        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;
        boolean correctGuess = false;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have generated a random number between 1 and 100. Can you guess it?");
        while (!correctGuess) 
        {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            if (userGuess < randomNumber) 
            {
                System.out.println("Too low! Try again.");
            } 
            else if (userGuess > randomNumber) 
            {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                correctGuess = true;
            }
        }
        scanner.close();
    }
}
