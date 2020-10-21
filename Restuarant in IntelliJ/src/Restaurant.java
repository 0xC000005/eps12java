import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Restaurant {
    private final Input input = new Input();
    private final ArrayList<Customer> customerList = new ArrayList<>();
    private static final double priceBurger = 3.99, priceDrinks = 1.99, priceFires = 2.99, priceCombo = 7.99, taxRate = 0.07;

    public Restaurant() {
        display();
    }

    public void display() {
        System.out.println("Welcome to Grease Burger!\n");
        while (true) {
            Customer newCustomer = new Customer();
            System.out.print("What's your Name? (type done when finished): ");
            String customerName = input.getString();
            if (customerName.equalsIgnoreCase("done")) break;
            else {
                setCustomerName(newCustomer, customerName);
            }
            setUserMenuDisplay(newCustomer);
            if (newCustomer.isUserMenuDisplay()) {
                displayUserMenu(newCustomer);
            }
            getUserOrder(newCustomer);
            individualCheckOut(newCustomer);
            addNewCustomer(customerList, newCustomer);
            System.out.println();
        }
        totalCheckOut(customerList);
    }

    public void setCustomerName(Customer currentCustomer, String customerName) {
        currentCustomer.setCustomerName(customerName);
    }

    public void setCombo(Customer currentCustomer) {
        int tempNumCombo = currentCustomer.getNumBurger();
        if (tempNumCombo > currentCustomer.getNumDrinks()) tempNumCombo = currentCustomer.getNumDrinks();
        if (tempNumCombo > currentCustomer.getNumFries()) tempNumCombo = currentCustomer.getNumFries();

        currentCustomer.setNumCombo(tempNumCombo);
        currentCustomer.setNumBurger(currentCustomer.getNumBurger() - currentCustomer.getNumCombo());
        currentCustomer.setNumDrinks(currentCustomer.getNumDrinks() - currentCustomer.getNumCombo());
        currentCustomer.setNumFries(currentCustomer.getNumFries() - currentCustomer.getNumCombo());
    }

    public BigDecimal getBill(Customer currentCustomer) {
        return BigDecimal.valueOf(currentCustomer.getNumBurger() * priceBurger + currentCustomer.getNumDrinks() * priceDrinks + currentCustomer.getNumFries() * priceFires + currentCustomer.getNumCombo() * priceCombo).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTax(Customer currentCustomer) {
        return BigDecimal.valueOf(taxRate * getBill(currentCustomer).doubleValue()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal(Customer currentCustomer) {
        return BigDecimal.valueOf(getBill(currentCustomer).doubleValue() + getTax(currentCustomer).doubleValue());
    }


    public void setUserMenuDisplay(Customer currentCustomer) {
        System.out.print("Hi " + currentCustomer.getCustomerName() + " would you like to see the menu? (Y/N)");
        String userMenuDisplayOption = input.getUserMenuDisplayOption();
        if (userMenuDisplayOption.equalsIgnoreCase("Y")) currentCustomer.setUserMenuDisplay(true);
        else if (userMenuDisplayOption.equalsIgnoreCase("N")) currentCustomer.setUserMenuDisplay(false);
    }

    public void displayUserMenu(Customer currentCustomer) {
        System.out.println("Hi " + currentCustomer.getCustomerName() + " here is our menu");
        System.out.println();
        System.out.println("Grease Burgers $3.99\n" +
                "Big Boy Drinks $1.99\n" +
                "Crunchy Fries  $2.99\n" +
                "Grease Combo   $7.99 (One of Each)");
        System.out.println();
    }

    public void getUserOrder(Customer currentCustomer) {
        System.out.print("How many Burgers? ");
        currentCustomer.setNumBurger(currentCustomer.getNumBurger() + input.getIntWithErrorCheck());
        System.out.print("How many Drinks? ");
        currentCustomer.setNumDrinks(currentCustomer.getNumDrinks() + input.getIntWithErrorCheck());
        System.out.print("How many Fries? ");
        currentCustomer.setNumFries(currentCustomer.getNumFries() + input.getIntWithErrorCheck());
    }

    public void individualCheckOut(Customer currentCustomer) {
        setCombo(currentCustomer);
        System.out.println("We gave you " + currentCustomer.getNumCombo() + " Grease combo! (you saved $" + String.format("%.2f", 0.98 * currentCustomer.getNumCombo()) + ")\n" +
                "Your total is $" + getTotal(currentCustomer) + " ($" + getBill(currentCustomer) + " + $" + getTax(currentCustomer) + " tax)");
        currentCustomer.setTotalBill(getTotal(currentCustomer).doubleValue());
    }

    public void totalCheckOut(ArrayList<Customer> customerArrayList) {
        for (Customer currentCustomer : customerArrayList) {
            System.out.println("Customer: " + currentCustomer.getCustomerName() + " owes $" + String.format("%.2f", currentCustomer.getTotalBill()));
        }
    }

    public void addNewCustomer(ArrayList<Customer> customerArrayList, Customer newCustomer) {
        customerArrayList.add(newCustomer);
    }

    public static void main(String[] args) {
        Restaurant testObject = new Restaurant();
    }
}
