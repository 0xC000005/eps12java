/**
 * @author m04.zhang
 * @version 2020-10-16
 * @project Test2 in IntelliJ
 * @description
 */
public class Car {

    private String make;
    private String model;
    private int year;
    private int mileage;
    private double price;

    public Car(String make, String model, int year, int mileage, double price)
    {
        setMake(make);
        setModel(model);
        setYear(year);
        setMileage(mileage);
        setPrice(price);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
