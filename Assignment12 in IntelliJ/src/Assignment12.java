/**
 * @author m04.zhang
 * @version 2020-10-21
 * @project Assignment12 in IntelliJ
 * @description
 */
public class Assignment12 {
    private int highestPossible = 100, lowestPossible = 1;

    public Assignment12() {

        Input input = new Input();
        System.out.print("Think of a number between 1 and 100 and then press any key.");
        input.pressAnyKeyToContinue();
        int userChoice = 0;
        while (userChoice != 3) {
            System.out.print("Is the number " + getMedium() + " (Correct, Low, High)? ");
            userChoice = input.getUserOptions();
            switch (userChoice) {
                case 1 -> highestPossible = getMedium();
                case 2 -> lowestPossible = getMedium();
            }
        }

    }

    private int getMedium() {
        return (highestPossible + lowestPossible) / 2;
    }

    public static void main(String[] args) {
        Assignment12 testObject = new Assignment12();
    }
}
