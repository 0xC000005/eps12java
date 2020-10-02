import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author m04.zhang
 * @version 2020-09-30
 * @project Assignment7b  in IntelliJ
 * @description
 */
public class Assignment7b {
    private double hourWorked, hourlyRate;
    private final Input input = new Input();

    public Assignment7b() {
        System.out.print("Enter hours worked: ");
        setHourWorked(input.getDoubleWithErrorCheck());
        System.out.print("Enter hourly rate: ");
        setHourlyRate(input.getDoubleWithErrorCheck());
        System.out.println("\n" +
                "Gross wages = $ " + String.format("%.2f", getGrossWage()));
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

    public double getGrossWage() {
        if (getHourWorked() > 40)
            return BigDecimal.valueOf(40 * getHourlyRate() + (getHourWorked() - 40) * getHourlyRate() * 1.5).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return BigDecimal.valueOf(getHourWorked() * getHourlyRate()).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        Assignment7b testObject = new Assignment7b();
    }
}


