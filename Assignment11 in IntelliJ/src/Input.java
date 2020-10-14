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

    public int getIntWithRangeErrorCheck() {
        try {
            int tempNum = scanner.nextInt();
            while (tempNum < 0 || tempNum > 5) {
                System.out.print("Bad input, can only accept number from 0 to 4: ");
                tempNum = scanner.nextInt();
            }
            return tempNum;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Not a number - Please input another number: ");
            scanner.nextLine(); // clear the buffer
            return getIntWithRangeErrorCheck();
        }
    }

    public int getIntWithNoneZeroErrorCheck() {
        try {
            int tempNum = scanner.nextInt();
            while (tempNum < 0) {
                System.out.print("Bad input, can only accept non-negative number: ");
                tempNum = scanner.nextInt();
            }
            return tempNum;
        } catch (java.util.InputMismatchException e) {
            System.out.print("Not a number - Please input another number: ");
            scanner.nextLine(); // clear the buffer
            return getIntWithRangeErrorCheck();
        }
    }
}
