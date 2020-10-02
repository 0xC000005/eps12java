public class student {
    private String studentName;
    private int studentNumber;
    private int studentAge;
    private double studentGrade;
    private boolean studentGraduatingStatus;

    public student(String _studentName, int _studnetNumber, int _studentAge, int _studentGrade, boolean _studentGraduatingStatus) {
        setStudentName(_studentName);
        setStudentNumber(_studnetNumber);
        setStudentAge(_studentAge);
        setStudentGrade(_studentGrade);
        setStudentGraduatingStatus(_studentGraduatingStatus);
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentGrade(double studentGrade) {
        this.studentGrade = studentGrade;
    }

    public double getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGraduatingStatus(boolean studentGraduatingStatus) {
        this.studentGraduatingStatus = studentGraduatingStatus;
    }

    public boolean isStudentGraduatingStatus() {
        return studentGraduatingStatus;
    }
}
