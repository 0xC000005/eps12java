import java.util.ArrayList;

/**
 * @author m04.zhang
 * @version 2020-11-03
 * @project Assignment14 in IntelliJ
 * @description
 */
public class Student {
    private String firstname, lastName;
    private final ArrayList<Course> courses = new ArrayList<>();

    public Student(String firstname, String lastName) {
        setFirstname(firstname);
        setLastName(lastName);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return getFirstname() + " " + getLastName();
    }

    public void addCourse(String name, int grade) {
        courses.add(new Course(name, grade));
    }

    public double getAverageMark() {
        double totalMarks = 0;
        for (Course currentCourse : courses) {
            totalMarks += currentCourse.getGrade();
        }
        return totalMarks / courses.size();
    }

    public String getAllCourses() {
        StringBuilder content = new StringBuilder();
        for (Course currentCourse : courses) {
            content.append(currentCourse.displayCourseInfo()).append("\t");
        }
        return content.toString();
    }

    public void displayStudentInfo() {
        System.out.print(getName() + "\tAverage Grade: " + String.format("%.2f", getAverageMark()) + "\n" +
                "\n" +
                "Block A\t\tBlock B\t\tBlock C\t\tBlock D\n" +
                getAllCourses() + "\n");
    }

}


