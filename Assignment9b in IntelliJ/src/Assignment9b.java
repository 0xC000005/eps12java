/**
 * @author m04.zhang
 * @version 2020-10-05
 * @project Assignment9b in IntelliJ
 * @description
 */
public class Assignment9b {
    private final Input input = new Input();
    int integer, numberOfDigits = 0, largestDenominator;

    public Assignment9b() {
        System.out.print("Enter an integer: ");
        setInteger(input.getIntWithErrorCheck());
        setNumberOfDigits(generateNumberOfDigits());
        setLargestDenominator(generateLargestDenominator());
        breakEachDigit();
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public void setNumberOfDigits(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }


    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public void setLargestDenominator(int largestDenominator) {
        this.largestDenominator = largestDenominator;
    }

    public int getLargestDenominator() {
        return largestDenominator;
    }

    public int generateNumberOfDigits() {
        int temp = integer, tempNumberOfDigits = 0;
        while (temp != 0) {
            temp /= 10;
            tempNumberOfDigits++;
        }
        return tempNumberOfDigits;
    }

    public int generateLargestDenominator() {
        int tempLargestDenominator = 1;
        for (int i = 0; i < getNumberOfDigits() - 1; i++) {
            tempLargestDenominator *= 10;
        }
        return tempLargestDenominator;
    }

    public void breakEachDigit() {
        while(getLargestDenominator()!=0)
        {
            System.out.println(getInteger()/getLargestDenominator());
            setInteger(getInteger()%getLargestDenominator());
            setLargestDenominator(getLargestDenominator()/10);
        }
    }

    public static void main(String[] args) {
        Assignment9b testObject = new Assignment9b();
    }

}
