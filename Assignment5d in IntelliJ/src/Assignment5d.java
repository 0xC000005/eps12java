import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author m04.zhang
 * @version 2020-09-22
 * @project Assignment5d in IntelliJ
 * @description
 */
public class Assignment5d {
    private Input input = new Input();
    private double change;
    private static final double Twoonie = 2.0, Loonie = 1.0, Quarter = 0.25, Dime = 0.1, Nickel = 0.01;
    private int numTwoonie, numLoonies, numQuarter, numDime, numNickel;

    public void setChange(double change) {
        this.change = change;
    }

    public double getChange() {
        return change;
    }

    public double roundUp(double num)
    {
        return BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public Assignment5d() {
        System.out.print("-------------------------------------------------------------\n" +
                "Enter the amount of change and PLEASE include the decimal $ ");
        setChange(input.getDouble());
        System.out.println();
        numTwoonie = (int) (getChange() / Twoonie);
        setChange(roundUp(getChange() - numTwoonie * Twoonie));
        numLoonies = (int) (getChange() / Loonie);
        setChange(roundUp(getChange() - numLoonies * Loonie));
        numQuarter = (int) (getChange() / Quarter);
        setChange(roundUp(getChange() - numQuarter * Quarter));
        numDime = (int) (getChange() / Dime);
        setChange(roundUp(getChange() - numDime * Dime));
        numNickel = (int) (getChange() / Nickel);

        System.out.println("Twoonie: " + numTwoonie + "\n" +
                "Loonies: " + numLoonies + "\n" +
                "Quarters: " + numQuarter + "\n" +
                "Dimes: " + numDime + "\n" +
                "Nickels: " + numNickel);

    }

    public static void main(String[] args) {
        Assignment5d testObject = new Assignment5d();
    }
}
