/**
 * @author m04.zhang
 * @version 2020-09-22
 * @project Assignment5c in IntelliJ
 * @description
 */
public class Assignment5c {
    private Input input = new Input();
    private int hours, minutes;

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getMinutesFirstDigit()
    {
        return getMinutes()/10;
    }

    public int getMinutesSecondDigit()
    {
        return getMinutes()%10;
    }

    public Assignment5c() {
        System.out.print("---------------------------------------------\n" +
                "Enter the number of minutes: ");
        setMinutes(input.getInt());
        setHours(getMinutes() / 60);
        setMinutes(getMinutes() - getHours() * 60);
        System.out.println("This is " + getHours() + ":" + getMinutesFirstDigit() + getMinutesSecondDigit() +"\n" +
                "----------------------------------------------");
    }

    public static void main(String[] args) {
        Assignment5c testObject = new Assignment5c();
    }
}

