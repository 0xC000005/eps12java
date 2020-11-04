/**
 * @author m04.zhang
 * @version 2020-11-03
 * @project Assignment14 in IntelliJ
 * @description
 */
public class Course {
    private String name;
    private double grade;

    public Course(String name, double grade) {
        setName(name);
        setGrade(grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String displayCourseInfo() {
        return getName() + " - " + getGrade();
    }
}
