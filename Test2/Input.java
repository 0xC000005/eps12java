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

    public String getStringWithErrorCheck() {

        scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        while(!(text.equalsIgnoreCase("M")||text.equalsIgnoreCase("P")))
        {
            System.out.print("Only allow M and P as input, please try again: ");
            text = scanner.nextLine();
        }
        return text;
    }

    /**
     * Gets the user's input
     *
     * @return the user's input as an int
     */

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
            return getIntWithNoneZeroErrorCheck();
        }
    }

    public double getDoubleWithNoneZeroErrorCheck() {
        try {
            double tempNum = scanner.nextInt();
            while (tempNum < 0) {
                System.out.print("Bad input, can only accept non-negative number: ");
                tempNum = scanner.nextInt();
            }
            return tempNum;
        } catch (java.util.InputMismatchException e) {
            System.out.print("Not a number - Please input another number: ");
            scanner.nextLine(); // clear the buffer
            return getDoubleWithNoneZeroErrorCheck();
        }
    }
}

