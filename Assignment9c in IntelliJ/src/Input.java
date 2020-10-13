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
        String character = scanner.nextLine();
        while (!(character.equalsIgnoreCase("Y") || character.equalsIgnoreCase("N"))) {
            System.out.print("Invalid input, only allow Y or N: ");
            character = scanner.nextLine();
        }
        return character;
    }

    //add
    public double getDoubleWithErrorCheck() {
        scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        while (num < 0) {
            System.out.print("Invalid input, can only input non-negative number: ");
            num = scanner.nextDouble();
        }
        return num;
    }

    /**
     * Gets the user's input
     *
     * @return the user's input as an int
     */

    public int getIntWithErrorCheck() {
        try {
            int num = scanner.nextInt();
            if (num < 0) {
                System.out.print("Invalid input, can only input non-negative number: ");
                num = scanner.nextInt();
            }
            return num;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Not a number - treating as zero");
            scanner.nextLine(); // clear the buffer
            return 0;
        }
    }
}
