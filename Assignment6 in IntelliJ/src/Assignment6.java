import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author m04.zhang
 * @version 2020-09-21
 * @project Assignment5b
 */
public class Assignment6 {
    private String name;
    private final Input input = new Input();
    private int numBurger, numDrinks, numFries, numCombo;
    private double payment;
    private static final double priceBurger = 1.99, priceDrinks = 0.99, priceFires = 1.79, priceCombo = 4.00, taxRate = 0.05;

    public Assignment6() {
        display();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumBurger(int numBurger) {
        this.numBurger = numBurger;
    }

    public int getNumBurger() {
        return numBurger;
    }

    public void setNumDrinks(int numDrinks) {
        this.numDrinks = numDrinks;
    }

    public int getNumDrinks() {
        return numDrinks;
    }

    public void setNumFries(int numFries) {
        this.numFries = numFries;
    }

    public int getNumFries() {
        return numFries;
    }

    public void setNumCombo() {
        numCombo = numBurger;
        if (numCombo > numDrinks) numCombo = numDrinks;
        if (numCombo > numFries) numCombo = numFries;

        setNumBurger(getNumBurger() - getNumCombo());
        setNumDrinks(getNumDrinks() - getNumCombo());
        setNumFries(getNumFries() - getNumCombo());
    }

    public int getNumCombo() {
        return numCombo;
    }

    public void setPayment(double payment) {
        if (getTotal().doubleValue() <= payment) {
            this.payment = payment;
        } else {
            System.out.print("Sorry, no enough money! Please input a bigger number: ");
            setPayment(input.getDouble());
        }
    }

    public double getPayment() {
        return payment;
    }

    public static double getTaxRate() {
        return taxRate;
    }

    public BigDecimal getBill() {
        return BigDecimal.valueOf(getNumBurger() * priceBurger + getNumDrinks() * priceDrinks + getNumFries() * priceFires + getNumCombo() * priceCombo).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTax() {
        return BigDecimal.valueOf(getTaxRate() * getBill().doubleValue()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal() {
        return BigDecimal.valueOf(getBill().doubleValue() + getTax().doubleValue());
    }

    public BigDecimal getChange() {
        return BigDecimal.valueOf(getPayment() - getTotal().doubleValue()).setScale(2, RoundingMode.HALF_UP);
    }

    public void display() {
        System.out.println("----------------------------------------------------\n" +
                "          Welcome to Fat Burger \n");
        System.out.print("What's your name? ");
        setName(input.getString());
        System.out.println();
        System.out.println("Hi " + getName() + " here is our menu");
        System.out.println();
        System.out.println("\tGrease Burger $1.99\n" +
                "\tDrinks        $0.99\n" +
                "\tFries         $1.79\n" +
                "The combo price (burgers,fries and a drink) will be 4.00$");
        System.out.println();
        System.out.print("How many Grease Burgers? ");
        setNumBurger(input.getInt());
        System.out.print("How many Fries? ");
        setNumFries(input.getInt());
        System.out.print("How many Drinks? ");
        setNumDrinks(input.getInt());
        setNumCombo();
        System.out.println();
        System.out.println("Your bill is $" + getBill() + "\n" +
                "Your bill with GST is $" + getTotal());
        System.out.println();
        System.out.print("Enter your payment $: ");
        setPayment(input.getDouble());
        System.out.println("Your change is     $" + getChange() + "\n" +
                "\n" +
                "Have a Nice Day!\n" +
                "--------------------------------------------------------");
    }

    public static void main(String[] args) {
        Assignment6 testObject = new Assignment6();
    }
}
