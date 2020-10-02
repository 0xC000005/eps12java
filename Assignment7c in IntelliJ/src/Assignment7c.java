import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author m04.zhang
 * @version 2020-09-30
 * @project Assignment7c  in IntelliJ
 * @description
 */
public class Assignment7c {
    private double hourWorked, hourlyRate;
    private static final double taxRate = 0.18;
    private final Input input = new Input();
    private boolean exempt;

    public Assignment7c() {
        System.out.print("Enter hours worked: ");
        setHourWorked(input.getDoubleWithErrorCheck());
        System.out.print("Enter hourly rate: ");
        setHourlyRate(input.getDoubleWithErrorCheck());
        System.out.print("Exempt (Y/N)? ");
        setExempt(input.getStringWithErrorCheck());
        System.out.println("\n" +
                "Gross wages = $ " + String.format("%.2f", getGrossWage()));
        if (isExempt()) System.out.println("NO TAXES DEDUCTED");
        else System.out.println("Wages after taxes = $" + String.format("%.2f", getTaxedGrossWage()));
    }

    public void setHourWorked(double hourWorked) {
        this.hourWorked = hourWorked;
    }

    public double getHourWorked() {
        return hourWorked;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setExempt(String character) {
        if (character.equalsIgnoreCase("Y")) this.exempt = true;
        else if (character.equalsIgnoreCase("N")) this.exempt = false;
    }

    public boolean isExempt() {
        return exempt;
    }

    public double getGrossWage() {
        if (getHourWorked() > 40)
            return BigDecimal.valueOf(40 * getHourlyRate() + (getHourWorked() - 40) * getHourlyRate() * 1.5).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return BigDecimal.valueOf(getHourWorked() * getHourlyRate()).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getTaxedGrossWage() {
        return BigDecimal.valueOf(getGrossWage() * (1 - taxRate)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        Assignment7c testObject = new Assignment7c();
    }
}