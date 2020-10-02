/**
 * @author m04.zhang
 * @version 2020-09-30
 * @project Assignment7a in IntelliJ
 * @description
 */
public class Assignment7a {
    final private Input input = new Input();
    private double weight;
    private double length;
    private double width;
    private double height;
    private boolean tooHeavy = false, tooLarge = false;

    public Assignment7a() {
        System.out.print("Enter weight of package in kilograms: ");
        setWeight(input.getDoubleWithErrorCheck());
        System.out.print("Enter length of package in meters: ");
        setLength(input.getDoubleWithErrorCheck());
        System.out.print("Enter width of package in meters: ");
        setWidth(input.getDoubleWithErrorCheck());
        System.out.print("Enter height of package in meters: ");
        setHeight(input.getDoubleWithErrorCheck());

        if (isPackageLegit()) System.out.println("Accepted.");
        else {
            System.out.print("Rejected: ");
            if (isTooLarge() && isTooHeavy()) System.out.print("Too heavy and too large");
            else if (isTooLarge()) System.out.print("Too heavy");
            else if (isTooHeavy()) System.out.print("Too large");
        }

    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getHeight() * getLength() * getWidth();
    }

    public void setTooHeavy(boolean tooHeavy) {
        this.tooHeavy = tooHeavy;
    }

    public boolean isTooHeavy() {
        return tooHeavy;
    }

    public void setTooLarge(boolean tooLarge) {
        this.tooLarge = tooLarge;
    }

    public boolean isTooLarge() {
        return tooLarge;
    }

    public boolean isPackageLegit() {
        if (getWeight() > 27) setTooHeavy(true);
        if (getVolume() > 0.1) setTooLarge(true);
        return !isTooHeavy() && !isTooLarge();
    }

    public static void main(String[] args) {
        Assignment7a testObject = new Assignment7a();
    }
}
