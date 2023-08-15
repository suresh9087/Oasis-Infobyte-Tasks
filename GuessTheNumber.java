   

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Welcome to Guess the Number!");
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                
                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    score += maxAttempts - attempts;
                    System.out.println("Congratulations! You guessed the number correctly.");
                } else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
                attempts++;
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts. The number was " + randomNumber);
            }
            
            System.out.println("Your score: " + score);
            System.out.print("Play again? (y/n): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("y");
            System.out.println();
        }
        
        System.out.println("Thank you for playing Guess the Number!");
    }
}