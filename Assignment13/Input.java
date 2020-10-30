import java.util.Scanner;

/**
 * Class InputReader reads user input from the keyboard.
 *
 * @author Max Zhang
 * @version 2019.02.13
 */

public class Input {
    private Scanner scanner;

    /**
     * Create a new InputReader to read user input.
     */
    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getString() {

        scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    /**
     * Gets the user's input
     *
     * @return the user's input as an int
     */

    public int getIntWithBetCheck(Player currentPlayer) {
        try {
            int tempNum = scanner.nextInt();
            while (tempNum < 0 || tempNum>currentPlayer.getMoney()) {
                System.out.print("Bad input, can only input a number between 0 and " + currentPlayer.getMoney() + ": ");
                tempNum = scanner.nextInt();
            }
            return tempNum;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Not a number - Please input another number: ");
            scanner.nextLine(); // clear the buffer
            return getIntWithBetCheck(currentPlayer);
        }
    }

}
