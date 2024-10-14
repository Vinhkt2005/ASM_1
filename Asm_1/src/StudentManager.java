import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }
    public void addStudent(String id, String name, double marks) {
        if (marks < 0 || marks > 10) {
            System.out.println("Invalid Marks! Please enter marks between 0 and 10.");
            return;
        }
        students.add(new Student(id, name, marks));
    }

    public void editStudent(String id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.set(students.indexOf(student), new Student(id, newName, newMarks)); // Update information
                break;
            }
        }
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void bubbleSortByMarks() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    public void mergeSortByMarks() {
        students = mergeSort(students);
    }
    private ArrayList<Student> mergeSort(ArrayList<Student> studentList) {
        if (studentList.size() <= 1) {
            return studentList;
        }
        int middle = studentList.size() / 2;
        ArrayList<Student> left = new ArrayList<>(studentList.subList(0, middle));
        ArrayList<Student> right = new ArrayList<>(studentList.subList(middle, studentList.size()));
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right) {
        ArrayList<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getMarks() >= right.get(j).getMarks()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }

    public Student searchStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}