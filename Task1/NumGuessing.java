import java.util.Scanner;
import java.util.Random;

public class NumGuessing {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int userGuess = 0; 
        System.out.println("A random number between 1 and 100 has been generated.");
        while (userGuess != randomNumber)
        {
            System.out.print("Enter your guess (1-100): ");
            userGuess = scanner.nextInt(); 
            if (userGuess < randomNumber) 
            {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber)
            {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
            }
        }
        scanner.close();
    }
}
