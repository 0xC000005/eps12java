import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Max Zhang
 * @version 2020-09-25
 * @project Quiz1 in IntelliJ
 * @description
 */
public class Quiz1 {
    private final Input input = new Input();
    private String name;
    private final int number = 5;
    private double num = 0;
    private final double taxPercent = 0.12;
    private double tax, subTotal = 0, average, grandTotal;

    public Quiz1() {
        System.out.println("--------------------------------------------------");
        System.out.print("Please enter your name: ");
        setName(input.getString());
        System.out.println("\n" +
                "Hello " + getName() + ". Please enter 5 prices.");
        System.out.println();
        for (int i = 0; i < number; i++) {
            System.out.print("Enter a price: ");
            setSubTotal(getSubTotal() + input.getDouble());
        }

        setTax(roundUp(getSubTotal()*taxPercent));
        setGrandTotal(roundUp(getSubTotal() + getTax()));
        setAverage(roundUp(getSubTotal() / number));

        System.out.println("\n" +
                "The total of these prices is $" + String.format("%.2f", getSubTotal()) + "\n" +
                "The PST/GST for this total is $" + String.format("%.2f", getTax()) + "\n" +
                "The total of these prices with PST/GST is $" + String.format("%.2f", getGrandTotal()) + "\n" +
                "\n" +
                "The average of these prices is $" + String.format("%.2f", getAverage()) + "\n" +
                "-------------------------------------------------------");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getNum() {
        return num;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double roundUp(double num) {
        return BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        Quiz1 testObject = new Quiz1();
    }
}
