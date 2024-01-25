import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        int tryCount = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Guess the Number Game\n++++++++++++++++++++++++++++++++++++");
        System.out.println();
        while(true) {
            System.out.println("\nI'm thinking between a number from 1 to 100.\nTry to guess it."); // if remove the \n wont reserve the space if you select Y to try again
            System.out.println();

            int computersNum = randomNumberGenerator();

            int usersGuess = usersGuess(scanner);
            do {
                if (usersGuess - computersNum >= 10) {
                    System.out.println("Way too high! Guess again.");
                    usersGuess = usersGuess(scanner);
                    tryCount++;
                }
                else if (computersNum - usersGuess >= 10) {
                    System.out.println("Way too low! Guess again.");
                    usersGuess = usersGuess(scanner);
                    tryCount++;
                }
                else if (usersGuess > computersNum) {
                    System.out.println("Too high! Guess again.");
                    usersGuess = usersGuess(scanner);
                    tryCount++;
                }
                else if (usersGuess < computersNum) {
                    System.out.println("Too low! Guess again.");
                    usersGuess = usersGuess(scanner);
                    tryCount++;
                }


            } while(usersGuess != computersNum);
            System.out.println("You got it in " + tryCount + " " + "tries.");

            if(tryCount > 7) {
                System.out.println("What took you so long? Maybe you should take some lessons.");
            } else if (tryCount > 3 && tryCount <= 7) {
                System.out.println("Not too bad! You've got some potential.");
            } else {
                System.out.println("Great Work! You are a guessing Wizard.");
            }

            if(!goAgain(scanner)){
                System.out.println("\nBye - Come back soon!");
                break;
            }
            tryCount = 1;
        }
    }

    private static int randomNumberGenerator() {
        Random randomNum = new Random();
        return randomNum.nextInt(100)+1;
    }

    private static int usersGuess(Scanner scanner) {
        System.out.print("Enter number: ");
        int usersInput = scanner.nextInt();
        scanner.nextLine();
        return usersInput;

    }
    private static boolean goAgain(Scanner scanner) {
        System.out.print("Try again? (y/n): ");
        String result = scanner.nextLine();

        return result.equalsIgnoreCase("y");
    }
}
