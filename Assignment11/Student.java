/**
 * @author m04.zhang
 * @version 2020-10-14
 * @project Assignment11 in IntelliJ
 * @description
 */
public class Student {
    private String studentName;
    private int studentGrade, studentNumber;

    public Student(String studentName, int studentGrade, int studentNumber) {
        setStudentName(studentName);
        setStudentGrade(studentGrade);
        setStudentNumber(studentNumber);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
