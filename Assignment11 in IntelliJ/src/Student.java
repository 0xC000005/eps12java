/**
 * @author m04.zhang
 * @version 2020-10-14
 * @project Assignment11 in IntelliJ
 * @description
 */
public class Student {
    private String studentFirstName, studentLastName;
    private int studentGrade, studentNumber;

    public Student(String studentFirstName, String studentLastName, int studentGrade, int studentNumber) {
        setStudentFirstName(studentFirstName);
        setStudentLastName(studentLastName);

        setStudentGrade(studentGrade);
        setStudentNumber(studentNumber);
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentName() {
        return getStudentFirstName() + " " + getStudentLastName();
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
