import java.util.Scanner;

/**
 * Class InputReader reads user input from the keyboard.
 *
 * @author Max Zhang
 * @version 2019.02.13
 */

public class Input {
    private final Scanner scanner;

    /**
     * Create a new InputReader to read user input.
     */
    public Input() {
        scanner = new Scanner(System.in);
    }

    public double getDoubleWithNoneZeroErrorCheck() {
        double number = scanner.nextDouble();
        while (number < 0) {
            System.out.print("Bad input, can only accept non-negative number: ");
            number = scanner.nextDouble();
        }
        return number;
    }

}

