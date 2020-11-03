import java.util.ArrayList;

/**
 * @author m04.zhang
 * @version 2020-11-03
 * @project Assignment14 in IntelliJ
 * @description
 */
public class Class {
    ArrayList<Student> students = new ArrayList<>();
    final Input input = new Input();

    public Class() {

    }

    public void runClass()
    {
        System.out.println("Class Roster\n");
        studentListDisplayOption();
    }

    public void addStudent(Student newStudent)
    {
        students.add(newStudent);
    }

    public void removeStudent()
    {
        students.remove(students.size()-1);
    }

    public void studentListDisplayOption() {
        System.out.print("Would you like to see the class list? (y/n): ");
        if (input.getUserOption()) displayClassList(students);
        System.out.print("What is the average grade cut line to display: ");
        displayStudentListAboveKeyAverage(input.getIntWithNoneZeroErrorCheck());
    }

    public void displayClassList(ArrayList<Student> studentList) {
        for (Student currentStudent : studentList) {
            currentStudent.displayStudentInfo();
            System.out.println();
        }
    }

    public void displayStudentListAboveKeyAverage(double key) {
        ArrayList<Student> studentsAboveAverage = new ArrayList<>();
        for (Student currentStudent : students) {
            if (currentStudent.getAverageMark() >= key) studentsAboveAverage.add(currentStudent);
        }
        displayClassList(studentsAboveAverage);
    }

    public static void main(String[] args) {
        //prep test data
        Student student1 = new Student("Billy", "Smith");
        student1.addCourse("MCMPR11" , 92);
        student1.addCourse("MGRPR11" , 95);
        student1.addCourse("ENGPR11" , 82);
        student1.addCourse("MTHPR11" , 90);
        Student student2 = new Student("Jenny", "Liu");
        student2.addCourse("MOMPR11", 100);
        student2.addCourse("ERRPR11", 90);
        student2.addCourse("ENGPR11", 90);
        student2.addCourse("MTHPR12", 100);
        Student student3 = new Student("Owen", "Lang");
        student3.addCourse("WWDPR11", 80);
        student3.addCourse("MMRPR11", 70);
        student3.addCourse("ENGPR12", 90);
        student3.addCourse("MTHPR11", 60);

        Class testObject = new Class();
        testObject.addStudent(student1);
        testObject.addStudent(student2);
        testObject.addStudent(student3);
        testObject.runClass();
    }
}

