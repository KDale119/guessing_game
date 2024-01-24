import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guess the Number Game\n++++++++++++++++++++++++++++++++++++");
        System.out.println();
        while(true) {
            System.out.println("\nI'm thinking between a number from 1 to 100.\nTry to guess it."); // if remove the \n wont reserve the space if you select Y to try again
            System.out.println();

            int computersNum = randomNumberGenerator();
            System.out.println(computersNum); //             REMOVE WHEN DONE
            int usersGuess = usersGuess();


            if (usersGuess > 100) { //&& usersGuess < 1 doesnt work???
                System.out.println("Not a valid guess\nTry again\nEnter number: ");
            } else if(usersGuess == computersNum) {
                System.out.println("You got it in 1 tries\nGreat work! You are a guessing wizard.");
            } else if (usersGuess > computersNum) {
                System.out.println("Way too high! Guess again.\nEnter number: ");
//                usersGuess();
            } else {
                System.out.println("Too low! Guess again\nEnter number: ");
//                usersGuess();
            }

            if(!goAgain()) {
                break;
            }
        }
    }

    private static int randomNumberGenerator() {
        Random randomNum = new Random();
        return randomNum.nextInt(100)+1;
    }

    private static int usersGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int usersInput = scanner.nextInt();
        scanner.nextLine();
        return usersInput;

    }
    private static boolean goAgain() {
        System.out.print("Try again? (y/n): ");
        Scanner response = new Scanner(System.in);
        String result = response.nextLine();
        return result.equalsIgnoreCase("y");
    }
}
