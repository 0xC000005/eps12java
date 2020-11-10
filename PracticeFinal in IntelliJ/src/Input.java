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

    public double getDoubleWithNoneZeorErrorCheck() {
        double number = scanner.nextDouble();
        while (number < 0) {
            System.out.print("Bad input, can only accept non-negative number: ");
            number = scanner.nextDouble();
        }
        return number;
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
            return getIntWithNoneZeroErrorCheck();
        }
    }
}
