import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManagement manager = new StudentManagement();

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" Student Record Management System");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        manager.addStudent(new Student(id, name, marks));
                        break;

                    case 2:

                        manager.viewStudents();
                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");
                        id = sc.nextInt();

                        manager.searchStudent(id);
                        break;

                    case 4:

                        System.out.print("Enter Student ID: ");
                        id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        name = sc.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter New Marks: ");
                        marks = sc.nextDouble();

                        manager.updateStudent(id, name, marks);
                        break;

                    case 5:

                        System.out.print("Enter Student ID: ");
                        id = sc.nextInt();

                        manager.deleteStudent(id);
                        break;

                    case 6:

                        System.out.println("Thank You!");
                        sc.close();
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid Input! Please enter correct data.");

                sc.nextLine();
            }
        }
    }
}