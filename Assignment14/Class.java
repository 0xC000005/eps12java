import java.util.ArrayList;
import java.util.Random;

/**
 * @author m04.zhang
 * @version 2020-11-03
 * @project Assignment14 in IntelliJ
 * @description
 */
public class Class {
    ArrayList<Student> students = new ArrayList<>();
    final Input input = new Input();
    private static final String[] NAMES = {"Billy", "Smith", "Jenny", "Liu", "Owen", "Lang", "Jack", "Ma", "Tony", "Max", "Brain", "Jimmy"};
    private static final String[] COURSETITLES = {"MCMPR11", "MGRPR11", "ENGPR11", "MTHPR11", "MOMPR11", "ERRPR11", "ENGPR11", "MTHPR12", "WWDPR11", "ENGPR12", "WWDPR11", "MTHPR11"};

    public Class() {

    }

    public void runClass()
    {
        loadClass(30);
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

    public int randNum(int max)
    {
        Random rand = new Random();
        return rand.nextInt(max + 1);
    }

    public void loadClass(int numberOfStudents)
    {
        for(int i=0;i<numberOfStudents;i++)
        {
            Student newStudent = new Student(NAMES[randNum(NAMES.length-1)], NAMES[randNum(NAMES.length-1)]);
            for(int x=0;x<4;x++)
            {
                newStudent.addCourse(COURSETITLES[randNum(COURSETITLES.length-1)], randNum(100));
            }
            addStudent(newStudent);
        }
    }

    public static void main(String[] args) {
        Class testObject = new Class();
        testObject.runClass();
    }
}

