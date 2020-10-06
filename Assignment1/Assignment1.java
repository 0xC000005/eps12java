/**
 * @author Max 
 * @version 2020-09-15
 */
public class Assignment1
{
    private String firstName;
    private String secondName;
    private int age;
    private double gpa;
    private boolean covidFree;
    
    public Assignment1() {
        }
    
    public Assignment1(String firstName, String secondName, int age, double gpa, boolean covidFree) {
            setFirstName(firstName);//"something"
            setSecondName(secondName);//"something else"
            setAge(age);//114514
            setGpa(gpa);//0.1919810
            setCovidFree(covidFree);//true
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        public void setGpa(double gpa) {
            this.gpa = gpa;
        }
    
        public void setCovidFree(boolean covidFree) {
            this.covidFree = covidFree;
        }
        
        public String getFirstName()
        {
            return  firstName;
        }
        
        public String getSecondName()
        {
            return secondName;
        }
        
        public int getAge()
        {
            return age;
        }
        
        public double getGpa()
        {
            return gpa;
        }
        
        public boolean isCovidFree()
        {
            return covidFree;
        }
        
        public void displayStudent()
        {
            System.out.println("First Name: " + getFirstName());
            System.out.println("Second Name: " + getSecondName());
            System.out.print("Age: " + getAge());
            System.out.println("   GPA: " + getGpa());
            System.out.println("isCovidFree: " + isCovidFree());
        }
}
