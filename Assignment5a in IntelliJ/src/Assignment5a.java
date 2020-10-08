import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author m04.zhang
 * @version 2020-09-21
 * @project Assignment5a
 */
public class Assignment5a {
    private String name;
    private Input input = new Input();
    private int numBurger, numDrinks, numFries;
    private static final double priceBurger = 1.99, priceDrinks = 0.99, priceFires = 1.79;

    public Assignment5a() {
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

    public static double getPriceBurger() {
        return priceBurger;
    }

    public static double getPriceDrinks() {
        return priceDrinks;
    }

    public static double getPriceFires() {
        return priceFires;
    }

    public BigDecimal getBill() {
        return BigDecimal.valueOf(getNumBurger() * priceBurger + getNumDrinks() * priceDrinks + getNumFries() * priceFires).setScale(2, RoundingMode.HALF_UP);
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
                "\tFries         $1.79");
        System.out.println();
        System.out.print("How many Grease Burgers? ");
        setNumBurger(input.getInt());
        System.out.print("How many Drinks? ");
        setNumDrinks(input.getInt());
        System.out.print("How many Fries? ");
        setNumFries(input.getInt());
        System.out.println();
        System.out.println("Your bill is $" + getBill() +"\n" +
                "have a Nice Day!\n" +
                "--------------------------------------------------------");
    }

    public static void main(String[] args) {
        Assignment5a testObject = new Assignment5a();
    }
}
