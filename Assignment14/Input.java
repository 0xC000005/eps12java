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

    public boolean getUserOption() {

        scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        while (!(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("N"))) {
            System.out.print("Wrong input, can only accept Y or N: ");
            option = scanner.nextLine();
        }

        if (option.equalsIgnoreCase("Y")) return true;
        return !option.equalsIgnoreCase("N");
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
