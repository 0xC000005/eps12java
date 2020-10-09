import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author m04.zhang
 * @version 2020-09-21
 * @project Assignment5b
 */
public class Assignment10 {
    private String name;
    private final Input input = new Input();
    private int numBurger, numDrinks, numFries, numPeople;
    private double payment;
    private boolean userMenuDisplay;
    private static final double priceBurger = 1.99, priceDrinks = 0.99, priceFires = 1.79, taxRate = 0.05;

    public Assignment10() {
        System.out.println("----------------------------------------------------\n" +
                "          Welcome to Fat Burger\n");
        getTotalUserNumber();
        for (int userNumber = 1; userNumber <= getNumPeople(); userNumber++) {
            newUserOrder(userNumber);
        }
        checkOut();
        System.out.print("\n" +
                "Have a Nice Day!\n" +
                "--------------------------------------------------------");
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

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setPayment(double payment) {
        if (getTotal().doubleValue() <= payment) {
            this.payment = payment;
        } else {
            System.out.print("Sorry, no enough money! Please input a bigger number: ");
            setPayment(input.getDoubleWithErrorCheck());
        }
    }

    public double getPayment() {
        return payment;
    }

    public static double getTaxRate() {
        return taxRate;
    }

    public BigDecimal getBill() {
        return BigDecimal.valueOf(getNumBurger() * priceBurger + getNumDrinks() * priceDrinks + getNumFries() * priceFires).setScale(2, RoundingMode.HALF_UP);
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

    public void getTotalUserNumber() {
        System.out.print("How many people are in your party (max is 6): ");
        setNumPeople(input.getNumPeopleWithErrorCheck());
    }

    public void getIndividualUserName(int userNumber) {
        System.out.println();
        System.out.print("Guest " + userNumber + ": What's your name? ");
        setName(input.getString());
    }

    public void setUserMenuDisplay() {
        System.out.print("Hi " + getName() + " would you like to see the menu? ");
        String userMenuDisplayOption = input.getUserMenuDisplayOption();
        if (userMenuDisplayOption.equalsIgnoreCase("Y")) userMenuDisplay = true;
        else if (userMenuDisplayOption.equalsIgnoreCase("N")) userMenuDisplay = false;
    }

    public boolean isUserDisplayMenu() {
        return userMenuDisplay;
    }

    public void displayUserMenu() {
        System.out.println("Hi " + getName() + " here is our menu");
        System.out.println();
        System.out.println("\tGrease Burger $1.99\n" +
                "\tDrinks        $0.99\n" +
                "\tFries         $1.79\n" +
                "The combo price (burgers,fries and a drink) will be 4.00$");
        System.out.println();
    }

    public void getUserOrder() {
        System.out.print("How many Grease Burgers? ");
        setNumBurger(getNumBurger() + input.getIntWithErrorCheck());
        System.out.print("How many Drinks? ");
        setNumDrinks(getNumDrinks() + input.getIntWithErrorCheck());
        System.out.print("How many Fries? ");
        setNumFries(getNumFries() + input.getIntWithErrorCheck());
    }

    public void checkOut() {
        System.out.println();
        System.out.println("Your bill is $" + getBill() + "\n" +
                "Your bill with GST is $" + getTotal());
        System.out.println();
        if (getBill().doubleValue() != 0 && getTotal().doubleValue() != 0) {

            System.out.print("Enter your payment $: ");
            setPayment(input.getDoubleWithErrorCheck());
            System.out.println("Your change is     $" + getChange());
        }

    }

    public void newUserOrder(int userNumber) {
        getIndividualUserName(userNumber);
        setUserMenuDisplay();
        if (isUserDisplayMenu()) {
            displayUserMenu();
        }
        getUserOrder();
    }

    public static void main(String[] args) {
        Assignment10 testObject = new Assignment10();
    }
}
