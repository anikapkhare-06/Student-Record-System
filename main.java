import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        loadFromFile();

        while (true) {
            System.out.println("\n1. Add/View/Search");
            System.out.println("2. Update/Delete");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addViewSearch();
                    break;
                case 2:
                    updateDelete();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    static void addViewSearch() {
        System.out.println("\n1. Add  2. View  3. Search");
        int ch = sc.nextInt();

        if (ch == 1) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt(); sc.nextLine();

            for (Student s : students) {
                if (s.id == id) {
                    System.out.println("ID exists!");
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
            System.out.println("Added!");
        }

        else if (ch == 2) {
            if (students.isEmpty()) {
                System.out.println("No data!");
                return;
            }

            for (Student s : students) {
                System.out.println(s.id + " " + s.name + " " + s.course + " " + s.marks);
            }
        }

        else if (ch == 3) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            for (Student s : students) {
                if (s.id == id) {
                    System.out.println("Found: " + s.name);
                    return;
                }
            }
            System.out.println("Not found!");
        }
    }

    static void updateDelete() {
        System.out.println("\n1. Update  2. Delete");
        int ch = sc.nextInt();

        if (ch == 1) {
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
                    System.out.println("Updated!");
                    return;
                }
            }
            System.out.println("Not found!");
        }

        else if (ch == 2) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            boolean removed = students.removeIf(s -> s.id == id);

            if (removed) {
                saveToFile();
                System.out.println("Deleted!");
            } else {
                System.out.println("Not found!");
            }
        }
    }

    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.id + "," + s.name + "," + s.course + "," + s.marks);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

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
            System.out.println("No file data");
        }
    }
}
