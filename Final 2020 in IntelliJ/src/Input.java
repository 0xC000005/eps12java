import java.util.Scanner;

public class Input {
    private Scanner scanner;

    /**
     * Create a new InputReader to read user input.
     */
    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getUserOptionForDisplay()
    {
        scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        while((!option.equalsIgnoreCase("a"))&&(!option.equalsIgnoreCase("g")))
        {
            System.out.print("Wrong input, can only accept input as 'a' or 'g' (ignore case):  ");
            option = scanner.nextLine();
        }
        return option.toLowerCase();
    }

    public String getUserOptionForDisplayByType()
    {
        scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if(!option.equalsIgnoreCase("c"))
            if(!option.equalsIgnoreCase("p"))
                if(!option.equalsIgnoreCase("r"))
                    if(!option.equalsIgnoreCase("h"))
                    {
                        System.out.print("Wrong Input, can only accept input as 'c', 'p', 'r' or 'h' (ignore case): ");
                        getUserOptionForDisplayByType();
                    }
        return option.toLowerCase();
    }
}
