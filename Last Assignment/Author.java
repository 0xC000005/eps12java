/**
 * @author m04.zhang
 * @version 2020-11-10
 * @project Last Assignment in IntelliJ
 * @description
 */
public class Author {
    private String firstName, LastName;

    public Author(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return  getLastName() + ", " + getFirstName();
    }
}
