/**
 * @author m04.zhang
 * @version 2020-10-05
 * @project Assignment9b in IntelliJ
 * @description
 */
public class Assignment9c {
    private final Input input = new Input();
    int integer, numberOfDigits = 0, largestDenominator, sumOfAllDigits = 0;

    public Assignment9c() {
        System.out.print("Enter an integer: ");
        setInteger(input.getIntWithErrorCheck());
        setNumberOfDigits(generateNumberOfDigits());
        setLargestDenominator(generateLargestDenominator());
        breakEachDigit();
        System.out.println("Sum of digits is " + getSumOfAllDigits());
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

    public void setSumOfAllDigits(int sumOfAllDigits) {
        this.sumOfAllDigits = sumOfAllDigits;
    }

    public int getSumOfAllDigits() {
        return sumOfAllDigits;
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
            setSumOfAllDigits(getSumOfAllDigits() + getInteger()/getLargestDenominator());
            setInteger(getInteger()%getLargestDenominator());
            setLargestDenominator(getLargestDenominator()/10);
        }
    }

    public static void main(String[] args) {
        Assignment9c testObject = new Assignment9c();
    }

}

