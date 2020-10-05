public class Assignment3 {
    private int num1;
    private int num2;

    public Assignment3() {
        System.out.println("Welcome to math addition.");
    }

    public Assignment3(int num1, int num2) {
        setNum1(num1);
        setNum2(num2);
        displayNumbers();
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum2() {
        return num2;
    }

    public int adding(int num1, int num2) {
        return num1 + num2;
    }

    public int subtracting(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplying(int num1, int num2) {
        return num1 * num2;
    }

    public int dividing(int num1, int num2)
    {
        if(num2!=0) return num1/num2;
        else
        {
            System.out.println("Can't divided by 0, return 0.");
            return 0;
        }
    }

    public int marbleDivision(int num1, int num2)
    {
        if(num2!=0) return num1%num2;
        else
        {
            System.out.println("Can't divided by 0, return 0.");
            return 0;
        }
    }



    public void displayNumbers() {
        System.out.println(getNum1() + " + " + getNum2() + " = " + adding(getNum1(), getNum2()));
        System.out.println(getNum1() + " - " + getNum2() + " = " + subtracting(getNum1(), getNum2()));
        System.out.println(getNum1() + " * " + getNum2() + " = " + multiplying(getNum1(), getNum2()));
        System.out.println(getNum1() + " / " + getNum2() + " = " + dividing(getNum1(), getNum2()));
        System.out.println(getNum1() + " % " + getNum2() + " = " + marbleDivision(getNum1(), getNum2()));
    }

    public static void main(String[] args) {
        Assignment3 testOutput = new Assignment3(1, 1);
    }
}
