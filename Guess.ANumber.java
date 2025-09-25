import java.util.Random;
import java.util.Scanner;  

public class GuessANumber {
    private static int rnd_number;

    public static void main(String[] args) {
        // pick a random number
        Random random = new Random();
        rnd_number = random.nextInt(100) + 1;
        System.out.println("I'm thinking of a number between 1 and 100 (including both).");
        System.out.println("Can you guess what it is?...");
        makeAGuess();
    }

    private static void makeAGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess: ");

        if (scanner.hasNextInt()) {
            int guess = scanner.nextInt();

            if (guess == rnd_number) {
                System.out.println("Congratulations! You guessed it right!");
                // scanner.close(); // optional: close if game ends here
            } else {
                if (guess < rnd_number) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                makeAGuess(); // recursive call for next guess
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
            makeAGuess(); // recursive call
        }

        // i dont the close scanner here if i plan to keep reading input recursively
    }
}
