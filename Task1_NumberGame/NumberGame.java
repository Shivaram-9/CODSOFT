import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int round = 1;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (true) {

            int secretNumber = random.nextInt(100) + 1;
            int attemptsLeft = 7;   // changed from normal 5 (unique)
            boolean isGuessed = false;

            System.out.println("\n🔹 Round " + round);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + attemptsLeft + " attempts");

            while (attemptsLeft > 0) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attemptsLeft--;

                if (guess == secretNumber) {
                    System.out.println("✅ Correct! You guessed it.");
                    totalScore += attemptsLeft + 1; // scoring logic (unique)
                    isGuessed = true;
                    break;
                } 
                else if (guess > secretNumber) {
                    System.out.println("📉 Too high! Try again.");
                } 
                else {
                    System.out.println("📈 Too low! Try again.");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!isGuessed) {
                System.out.println("❌ You lost! The number was: " + secretNumber);
            }

            System.out.println("🏆 Current Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }

            round++;
        }

        System.out.println("\n🎉 Final Score: " + totalScore);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}
