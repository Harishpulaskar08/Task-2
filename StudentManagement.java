import java.util.ArrayList;

public class StudentManagement {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {

        if (findStudentById(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        if (student.getMarks() < 0 || student.getMarks() > 100) {
            System.out.println("Marks should be between 0 and 100.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    // View Students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records found.");
            return;
        }

        System.out.println("\n========= Student Records =========");

        for (Student s : students) {

            System.out.println("------------------------------");
            System.out.println(s);
        }

        System.out.println("------------------------------");
    }

    // Search Student
    public void searchStudent(int id) {

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nStudent Found");
        System.out.println("------------------------------");
        System.out.println(student);
        System.out.println("------------------------------");
    }

    // Update Student
    public void updateStudent(int id, String newName, double newMarks) {

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        if (newMarks < 0 || newMarks > 100) {
            System.out.println("Marks should be between 0 and 100.");
            return;
        }

        student.setName(newName);
        student.setMarks(newMarks);

        System.out.println("Student updated successfully.");
    }

    // Delete Student
    public void deleteStudent(int id) {

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);

        System.out.println("Student deleted successfully.");
    }

    // Helper Method
    private Student findStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}