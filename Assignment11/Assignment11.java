import java.util.ArrayList;

/**
 * @author m04.zhang
 * @version 2020-10-14
 * @project Assignment11 in IntelliJ
 * @description
 */
public class Assignment11 {
    private final Input input = new Input();
    private final ArrayList<Student> studentList = new ArrayList<>();

    public Assignment11() {
        int userChoice;
        System.out.println("Tsang's Programming class \n");
        do {
            System.out.println("Input 1 to add a new student at the end of the list.");
            System.out.println("Input 2 to delete the student at the end of the list.");
            System.out.println("Input 3 to delete the student with a specific name.");
            System.out.println("Input 4 to show the current length of the student list.");
            System.out.println("Input 5 to display all student in the list.");
            System.out.println("Input 0 to exit the program.\n");
            System.out.print("Choose a option to operate: ");
            userChoice = input.getIntWithRangeErrorCheck();
            userOperationSwitcher(userChoice);
        } while (userChoice != 0);
    }

    public void userOperationSwitcher(int userChoice) {
        switch (userChoice) {
            case 1: 
                addStudentAtTheEnd();
                break;
            case 2:
                deleteLastStudent();
                break;
            case 3:
                deleteStudentWithName();
                break;
            case 4:
                displayStudentListLength();
                break;
            case 5:
                displayStudentList(studentList);
                break;
        }
        System.out.println();
    }

    public void addStudentAtTheEnd() {
        String studentName;
        int studentGrade, studentNumber;
        System.out.print("Input student's name: ");
        studentName = input.getString();
        System.out.print("Input student's grade: ");
        studentGrade = input.getIntWithNoneZeroErrorCheck();
        System.out.print("Input student's student number: ");
        studentNumber = input.getIntWithNoneZeroErrorCheck();
        Student newStudent = new Student(studentName, studentGrade, studentNumber);
        studentList.add(newStudent);
    }

    public void deleteLastStudent() {
        System.out.println("The student " + studentList.get(studentList.size() - 1).getStudentName() + "will be deleted.");
        studentList.remove(studentList.size() - 1);
    }

    public void deleteStudentWithName() {
        System.out.print("Input the name of student that you want to delete: ");
        String studentNameForDelete = input.getString();
        ArrayList<Student> studentListForDelete = new ArrayList<>();

        for (Student currentStudent : studentList) {
            if (currentStudent.getStudentName().equals(studentNameForDelete)) {
                studentListForDelete.add(currentStudent);
            }
        }

        for (Student studentNeedsToDelete : studentListForDelete) {
            studentList.remove(studentNeedsToDelete);
        }
    }

    public void displayStudentListLength() {
        System.out.println("The length of student list is " + studentList.size());
    }

    public void displayIndividualStudent(Student currentStudent) {
        System.out.println("Name: " + currentStudent.getStudentName() + "\n" +
                "Grade: " + currentStudent.getStudentGrade() + "\n" +
                "Student Number: " + currentStudent.getStudentNumber());
    }

    public void displayStudentList(ArrayList<Student> studentList) {
        for (Student currentStudent : studentList) {
            displayIndividualStudent(currentStudent);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Assignment11 testObject = new Assignment11();
    }
}

