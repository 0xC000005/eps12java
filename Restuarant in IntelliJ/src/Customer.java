/**
 * @author m04.zhang
 * @version 2020-10-20
 * @project Restuarant in IntelliJ
 * @description
 */
public class Customer {
    private String CustomerName;
    private double totalBill;
    private int numBurger, numDrinks, numFries, numCombo;
    private boolean userMenuDisplay;

    public Customer() {

    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public int getNumBurger() {
        return numBurger;
    }

    public void setNumBurger(int numBurger) {
        this.numBurger = numBurger;
    }

    public int getNumDrinks() {
        return numDrinks;
    }

    public void setNumDrinks(int numDrinks) {
        this.numDrinks = numDrinks;
    }

    public int getNumFries() {
        return numFries;
    }

    public void setNumFries(int numFries) {
        this.numFries = numFries;
    }

    public int getNumCombo() {
        return numCombo;
    }

    public void setNumCombo(int numCombo) {
        this.numCombo = numCombo;
    }

    public boolean isUserMenuDisplay() {
        return userMenuDisplay;
    }

    public void setUserMenuDisplay(boolean userMenuDisplay) {
        this.userMenuDisplay = userMenuDisplay;
    }
}
