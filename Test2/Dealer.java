import java.util.ArrayList;

/**
 * @author m04.zhang
 * @version 2020-10-16
 * @project Test2 in IntelliJ
 * @description
 */
public class Dealer {
    private ArrayList<Car> carList = new ArrayList<>();
    private final Input myInput = new Input();

    public void addNewCarToCarList(Car newCar) {
        carList.add(newCar);
    }

    public void display() {
        System.out.println("Here are our cars\n");
        displayCarArrayList(carList);
        System.out.print("\nWhat details would you like to narrow the list by?\n" +
                "\n" +
                "Mileage (m) or Price (p): ");
        String userChoice = myInput.getStringWithErrorCheck();
        System.out.println();
        userChoiceSwitcher(userChoice);
    }

    public void displayCarArrayList(ArrayList<Car> carArrayList) {
        for (Car currentCar : carArrayList) {
            System.out.println(currentCar.getYear() + " " + currentCar.getMake() + " " + currentCar.getModel());
        }
    }

    public void userChoiceSwitcher(String userChoice) {
        if (userChoice.equalsIgnoreCase("m")) {
            System.out.print("What is the maximum mileage: ");
            int maximumMileage = myInput.getIntWithNoneZeroErrorCheck();
            System.out.println();
            searchCarByMaximumMileage(carList, maximumMileage);
        } else if (userChoice.equalsIgnoreCase("p")) {
            System.out.print("What is the maximum price: ");
            double maximumPrice = myInput.getDoubleWithNoneZeroErrorCheck();
            System.out.println();
            searchCarByMaximumPrice(carList, maximumPrice);
        }
    }

    public void searchCarByMaximumMileage(ArrayList<Car> carArrayList, int maximumMileage) {
        ArrayList<Car> carListBelowMaximumMileage = new ArrayList<>();
        for (Car currentCar : carArrayList) {
            if (currentCar.getMileage() <= maximumMileage) {
                carListBelowMaximumMileage.add(currentCar);
            }
        }

        for (Car currentCar : carListBelowMaximumMileage) {
            System.out.println(currentCar.getYear() + " " + currentCar.getMake() + " " + currentCar.getModel() + " has " + currentCar.getMileage() + "km");
        }
    }

    public void searchCarByMaximumPrice(ArrayList<Car> carArrayList, double maximumPrice) {
        ArrayList<Car> carListBelowMaximumPrice = new ArrayList<>();
        for (Car currentCar : carArrayList) {
            if (currentCar.getPrice() <= maximumPrice) {
                carListBelowMaximumPrice.add(currentCar);
            }
        }

        for (Car currentCar : carListBelowMaximumPrice) {
            System.out.println(currentCar.getYear() + " " + currentCar.getMake() + " " + currentCar.getModel() + " $" + currentCar.getPrice());
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Ford", "Focus", 1999, 16000, 4950.00);
        Car car2 = new Car("Honda", "Fit", 2017, 16000, 9990.00);
        Car car3 = new Car("Dodge", "Viper", 1995, 16000, 8500.99);
        Car car4 = new Car("BMW", "X5", 2015, 14000, 15000);
        Car car5 = new Car("Acura", "RSX", 2012, 11500, 15000);

        Dealer testObject = new Dealer();
        testObject.addNewCarToCarList(car1);
        testObject.addNewCarToCarList(car2);
        testObject.addNewCarToCarList(car3);
        testObject.addNewCarToCarList(car4);
        testObject.addNewCarToCarList(car5);
        testObject.display();
    }
}

