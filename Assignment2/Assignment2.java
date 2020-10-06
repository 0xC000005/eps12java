/**
 * Write a description of class test here.
 *
 * @author Max
 * @version 2020-09-21
 */

public class Assignment2 {
    private final student student;
    private final schedule q1;
    private final schedule q2;
    private final schedule q3;
    private final schedule q4;

    public Assignment2(String studentName, int studentNumber, int studentAge, int studentGrade, boolean studentGraduatingStatus, String termName1, String term1FirstCourseOrder, String term1FirstCourseTitle, String term1SecondCourseOrder, String term1SecondCourseTitle, String termName2, String term2FirstCourseOrder, String term2FirstCourseTitle, String term2SecondCourseOrder, String term2SecondCourseTitle, String termName3, String term3FirstCourseOrder, String term3FirstCourseTitle, String term3SecondCourseOrder, String term3SecondCourseTitle, String termName4, String term4FirstCourseOrder, String term4FirstCourseTitle, String term4SecondCourseOrder, String term4SecondCourseTitle) {
        student = new student(studentName, studentNumber, studentAge, studentGrade, studentGraduatingStatus);
        q1 = new schedule(termName1, term1FirstCourseOrder, term1FirstCourseTitle, term1SecondCourseOrder, term1SecondCourseTitle);
        q2 = new schedule(termName2, term2FirstCourseOrder, term2FirstCourseTitle, term2SecondCourseOrder, term2SecondCourseTitle);
        q3 = new schedule(termName3, term3FirstCourseOrder, term3FirstCourseTitle, term3SecondCourseOrder, term3SecondCourseTitle);
        q4 = new schedule(termName4, term4FirstCourseOrder, term4FirstCourseTitle, term4SecondCourseOrder, term4SecondCourseTitle);
        display();
    }

    public void displaySchedule(schedule q) {
        System.out.println("Schedule " + q.getTerm());
        System.out.println("Block " + q.getFirstCourse().getBlockOrder() + " " + q.getFirstCourse().getCourseTitle());
        System.out.println("Block " + q.getSecondCourse().getBlockOrder() + " " + q.getSecondCourse().getCourseTitle() + "\n");
    }

    public void displayStudent(student student) {
        System.out.println("Name: " + student.getStudentName());
        System.out.println("Student Num: " + student.getStudentNumber());
        System.out.println("Age: " + student.getStudentAge() + "    Grade: " + student.getStudentGrade());
        System.out.println("Graduating: " + student.isStudentGraduatingStatus() + "\n");

    }

    public void display() {
        displayStudent(student);
        displaySchedule(q1);
        displaySchedule(q2);
        displaySchedule(q3);
        displaySchedule(q4);
    }
}

