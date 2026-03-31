import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {

        loadFromFile();

        while (true) {
            System.out.println("\n====== STUDENT RECORD SYSTEM ======");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 0: 
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ADD
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, course, marks));
        saveToFile();
        System.out.println("Student Added!");
    }

    // VIEW
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No data available!");
            return;
        }

        for (Student s : students) {
            System.out.println(s.id + " | " + s.name + " | " + s.course + " | " + s.marks);
        }
    }

    // SEARCH
    static void searchStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Found: " + s.name);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // UPDATE
    static void updateStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {

                System.out.print("New Name: ");
                s.name = sc.nextLine();

                System.out.print("New Course: ");
                s.course = sc.nextLine();

                System.out.print("New Marks: ");
                s.marks = sc.nextDouble();

                saveToFile();
                System.out.println("Updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // DELETE
    static void deleteStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        boolean removed = students.removeIf(s -> s.id == id);

        if (removed) {
            saveToFile();
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // SAVE FILE
    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.id + "," + s.name + "," + s.course + "," + s.marks);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }

    // LOAD FILE
    static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                students.add(new Student(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Double.parseDouble(d[3])
                ));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }
}
