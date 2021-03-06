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
        if(!(character.equalsIgnoreCase("Y")||character.equalsIgnoreCase("N")))
        {
            System.out.print("Invalid input, only allow Y or N: ");
            getStringWithErrorCheck();
        }
        return character;
    }

    //add
    public double getDoubleWithErrorCheck() {
        scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        if (num <= 0) {
            System.out.print("Invalid input, try another positive number: ");
            getDoubleWithErrorCheck();
        }
        return num;
    }

    /**
     * Gets the user's input
     *
     * @return the user's input as an int
     */

    public int getInt() {
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Not a number - treating as zero");
            scanner.nextLine(); // clear the buffer
            return 0;
        }
    }
}

