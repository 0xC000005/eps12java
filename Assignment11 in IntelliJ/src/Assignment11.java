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
            case 1 -> addStudentAtTheEnd();
            case 2 -> deleteLastStudent();
            case 3 -> deleteStudentByFirstName();
            case 4 -> displayStudentListLength();
            case 5 -> displayStudentList(studentList);
        }
        System.out.println();
    }

    public void addStudentAtTheEnd() {
        String studentFirstName, studentLastName;
        int studentGrade, studentNumber;
        System.out.print("Input student's first name: ");
        studentFirstName = input.getString();
        System.out.print("Input student's last name: ");
        studentLastName = input.getString();
        System.out.print("Input student's grade: ");
        studentGrade = input.getIntWithNoneZeroErrorCheck();
        System.out.print("Input student's student number: ");
        studentNumber = input.getIntWithNoneZeroErrorCheck();
        Student newStudent = new Student(studentFirstName, studentLastName, studentGrade, studentNumber);
        studentList.add(newStudent);
    }

    public void deleteLastStudent() {
        System.out.println("The student " + studentList.get(studentList.size() - 1).getStudentName() + " will be deleted.");
        studentList.remove(studentList.size() - 1);
    }

    public void deleteStudentByFirstName() {
        System.out.print("Input the first name of student that you want to delete: ");
        String studentFirstNameForDelete = input.getString();
        ArrayList<Student> studentListHavingSameFirstNameForDelete = new ArrayList<>();

        for (Student currentStudent : studentList) {
            if (currentStudent.getStudentFirstName().equals(studentFirstNameForDelete)) {
                studentListHavingSameFirstNameForDelete.add(currentStudent);
            }
        }

        if (studentListHavingSameFirstNameForDelete.size() == 0) {
            System.out.println("Can't find any student with the first name " + studentFirstNameForDelete);
        } else if (studentListHavingSameFirstNameForDelete.size() == 1) {
            for (Student studentHavingSameFirstNameNeedsToDelete : studentListHavingSameFirstNameForDelete) {
                studentList.remove(studentHavingSameFirstNameNeedsToDelete);
            }
        } else {
            System.out.println("We have multiple students named " + studentFirstNameForDelete + ", display all students with the correspond first name: ");
            displayStudentList(studentListHavingSameFirstNameForDelete);
            System.out.print("Input the last name of student that you want to delete: ");
            String studentLastNameForDelete = input.getString();
            ArrayList<Student> studentListHavingSameFirstAndLastNameForDelete = new ArrayList<>();
            for (Student currentStudentWithSameFirstName : studentListHavingSameFirstNameForDelete) {
                if (currentStudentWithSameFirstName.getStudentLastName().equals(studentLastNameForDelete)) {
                    studentListHavingSameFirstAndLastNameForDelete.add(currentStudentWithSameFirstName);
                }
            }

            if (studentListHavingSameFirstAndLastNameForDelete.size() == 0) {
                System.out.println("Can't find any student with the first name " + studentFirstNameForDelete + " and the last name " + studentLastNameForDelete);
            } else if (studentListHavingSameFirstAndLastNameForDelete.size() == 1) {
                for (Student studentHavingSameFirstAndLastNameNeedDelete : studentListHavingSameFirstAndLastNameForDelete) {
                    studentList.remove(studentHavingSameFirstAndLastNameNeedDelete);
                }
            } else {
                System.out.println("We have multiple students who have the same name " + studentFirstNameForDelete + " " + studentLastNameForDelete + ", display all students with the correspond first and last name: ");
                displayStudentList(studentListHavingSameFirstAndLastNameForDelete);
                System.out.print("Input the student number of student that you want to delete: ");
                int studentNumberForDelete = input.getIntWithNoneZeroErrorCheck();
                ArrayList<Student> studentListHavingSameStudentNumber = new ArrayList<>();
                for (Student studentHavingSameStudentNumber : studentListHavingSameFirstAndLastNameForDelete) {
                    if (studentHavingSameStudentNumber.getStudentNumber() == studentNumberForDelete) {
                        studentListHavingSameStudentNumber.add(studentHavingSameStudentNumber);
                    }
                }

                if (studentListHavingSameStudentNumber.size() == 0) {
                    System.out.println("Can't find any student with the student named " + studentFirstNameForDelete + " " + studentLastNameForDelete + " and also having the student number " + studentNumberForDelete);
                } else if (studentListHavingSameStudentNumber.size() == 1) {
                    for (Student studentHavingSameStudentNumberForDelete : studentListHavingSameStudentNumber) {
                        studentList.remove(studentHavingSameStudentNumberForDelete);
                    }
                }
            }
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
