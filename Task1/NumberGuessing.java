import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        int min = 1;
        int max = 100;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;

       
        System.out.println("Guess the number between " + min + " and " + max + ": ");
        int userGuess = scanner.nextInt();

        
        if (userGuess == randomNumber) {
            System.out.println("Congratulations! You guessed the correct number.");
        } else {
            System.out.println("Sorry, the correct number was " + randomNumber + ".");
        }

        
        scanner.close();
    }
}
