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

    public int getUserOptions() {

        scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        if (!userChoice.equalsIgnoreCase("h")) {
            if (!userChoice.equalsIgnoreCase("l")) {
                if (!userChoice.equalsIgnoreCase("c")) {
                    System.out.print("Wrong input, can only accept h/l/c: ");
                    getUserOptions();
                } else if (userChoice.equalsIgnoreCase("c")) {
                    return 3;
                }
            } else if (userChoice.equalsIgnoreCase("l")) {
                return 2;
            }
        } else if (userChoice.equalsIgnoreCase("h")) {
            return 1;
        }
        return 0;
    }


    public void pressAnyKeyToContinue() {
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}
