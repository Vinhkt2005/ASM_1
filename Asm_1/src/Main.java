import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("---------Menu--------");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student Information");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Marks using Bubble Sort");
            System.out.println("5. Sort Students by Marks using Merge Sort");
            System.out.println("6. Search Student by ID");
            System.out.println("7. Search Student by Name");
            System.out.println("8. Display All Students");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine().trim();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine().trim();
                    double marks;
                    while (true) {
                        System.out.print("Enter Marks (0-10): ");
                        try {
                            marks = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid marks! Please enter a numeric value between 0 and 10.");
                        }
                    }
                    manager.addStudent(id, name, marks);
                    break;
                case 2:
                    System.out.print("Enter ID of the student to edit: ");
                    String editId = scanner.nextLine().trim();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine().trim();
                    double newMarks;
                    while (true) {
                        System.out.print("Enter New Marks (0-10): ");
                        try {
                            newMarks = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid marks! Please enter a numeric value between 0 and 10.");
                        }
                    }
                    manager.editStudent(editId, newName, newMarks);
                    break;
                case 3:
                    System.out.print("Enter ID of the student to delete: ");
                    String deleteId = scanner.nextLine().trim();
                    manager.deleteStudent(deleteId);
                    break;
                case 4:
                    manager.bubbleSortByMarks();
                    System.out.println("Students have been sorted using Bubble Sort.");
                    break;
                case 5:
                    manager.mergeSortByMarks();
                    System.out.println("Students have been sorted using Merge Sort.");
                    break;
                case 6:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine().trim();
                    Student foundStudent = manager.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter Student Name to search: ");
                    String searchName = scanner.nextLine().trim();
                    ArrayList<Student> foundStudents = manager.searchStudentByName(searchName);
                    if (!foundStudents.isEmpty()) {
                        for (Student student : foundStudents) {
                            System.out.println(student);
                        }
                    } else {
                        System.out.println("No students found with the given name.");
                    }
                    break;
                case 8:
                    manager.displayAllStudents();
                    break;
                case 9:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 9.");
                    break;
            }
        }
    }
}