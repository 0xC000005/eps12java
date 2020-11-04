import java.util.Arrays;

/**
 * @author m04.zhang
 * @version 2020-10-05
 * @project Assignment9a in IntelliJ
 * @description
 */
public class Assignment9a {
    private static final Integer carModelNeedFix[] = {119, 179, 189, 119, 179, 189, 780};
    private int userCarModel;
    private final Input input = new Input();

    public Assignment9a() {
        do {
            System.out.print("Enter your model number (0 for done): ");
            setUserCarModel(input.getIntWithErrorCheck());
            if (Arrays.asList(carModelNeedFix).contains(getUserCarModel())) {
                System.out.println("Your car is defective. Please have it fixed.");
            } else if(getUserCarModel()!=0){
                System.out.println("Your car is OK.");
            }
        } while (getUserCarModel() != 0);
        System.out.println("Program complete.");
    }

    public void setUserCarModel(int userCarModel) {
        this.userCarModel = userCarModel;
    }

    public int getUserCarModel() {
        return userCarModel;
    }

    public static void main(String[] args) {
        Assignment9a testObject = new Assignment9a();
    }
}
