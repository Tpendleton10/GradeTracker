import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main entry point for the Student Grade Tracker application.
 *
 * Features:
 *  - Add students and record their assignments and exams
 *  - View individual student reports with weighted averages
 *  - View class summary with overall average
 *  - Save/load grade data to a CSV file
 *
 * Demonstrates: variables, expressions, conditionals, loops, functions,
 * classes, ArrayList (Collections Framework), file I/O, inheritance,
 * abstract classes, and interfaces.
 */
public class GradeTracker {

    // ArrayList to store all students (Java Collections Framework)
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Application entry point. Shows the main menu and routes user choices.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("     Welcome to Student Grade Tracker      ");
        System.out.println("===========================================");

        // Seed some demo data so the app is usable right away
        loadDemoData();

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");

            // Conditional to route menu choices
            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                addAssessmentToStudent();
            } else if (choice == 3) {
                viewStudentReport();
            } else if (choice == 4) {
                viewClassSummary();
            } else if (choice == 5) {
                FileManager.saveToFile(students);
            } else if (choice == 6) {
                FileManager.loadAndDisplay();
            } else if (choice == 0) {
                System.out.println("\nGoodbye! Saving data before exit...");
                FileManager.saveToFile(students);
                running = false;
            } else {
                System.out.println("  Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("  1. Add a new student");
        System.out.println("  2. Add an assessment to a student");
        System.out.println("  3. View a student's report");
        System.out.println("  4. View class summary");
        System.out.println("  5. Save data to file");
        System.out.println("  6. Load and display saved file");
        System.out.println("  0. Exit");
    }

    /**
     * Prompts the user to enter a new student's name and ID,
     * then adds the student to the students list.
     */
    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("  Enter student name: ");
        String name = scanner.nextLine().trim();
        System.out.print("  Enter student ID: ");
        String id = scanner.nextLine().trim();

        // Check for duplicate ID using a loop
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("  A student with ID '" + id + "' already exists.");
                return;
            }
        }

        Student newStudent = new Student(name, id);
        students.add(newStudent);
        System.out.println("  Student '" + name + "' added successfully!");
    }

    /**
     * Lets the user select a student and then choose what type of
     * assessment (Assignment or Exam) to add to that student's record.
     */
    private static void addAssessmentToStudent() {
        System.out.println("\n--- Add Assessment ---");

        // Guard clause: ensure there are students to add to
        if (students.isEmpty()) {
            System.out.println("  No students found. Please add a student first.");
            return;
        }

        Student student = selectStudent();
        if (student == null) return;

        System.out.println("  Assessment type:");
        System.out.println("    1. Assignment");
        System.out.println("    2. Exam (with weight)");
        int typeChoice = readInt("  Choose type (1 or 2): ");

        System.out.print("  Assessment name: ");
        String name = scanner.nextLine().trim();
        double score = readDouble("  Score earned: ");
        double maxScore = readDouble("  Maximum score: ");

        // Validate score range using an expression/conditional
        if (score < 0 || score > maxScore) {
            System.out.println("  Invalid score. Must be between 0 and max score.");
            return;
        }

        if (typeChoice == 1) {
            student.addAssessment(new Assignment(name, score, maxScore));
            System.out.println("  Assignment added!");
        } else if (typeChoice == 2) {
            double weight = readDouble("  Exam weight (e.g., 1.0 for normal, 1.5 for weighted): ");
            student.addAssessment(new Exam(name, score, maxScore, weight));
            System.out.println("  Exam added!");
        } else {
            System.out.println("  Invalid type selection.");
        }
    }

    /**
     * Displays a detailed grade report for a user-selected student.
     */
    private static void viewStudentReport() {
        System.out.println("\n--- View Student Report ---");
        if (students.isEmpty()) {
            System.out.println("  No students found.");
            return;
        }

        Student student = selectStudent();
        if (student != null) {
            student.printReport();
        }
    }

    /**
     * Displays a summary of all students including their average
     * and letter grade, then computes the overall class average.
     */
    private static void viewClassSummary() {
        System.out.println("\n--- Class Summary ---");
        if (students.isEmpty()) {
            System.out.println("  No students found.");
            return;
        }

        double classTotal = 0.0;
        int studentCount = students.size();

        // Loop through all students
        for (Student s : students) {
            double avg = s.calculateAverage();
            classTotal += avg;
            System.out.printf("  %-20s | ID: %-8s | Avg: %6.2f%% | Grade: %s%n",
                    s.getName(), s.getStudentId(), avg, s.getLetterGrade(avg));
        }

        // Expression: compute class average
        double classAverage = classTotal / studentCount;
        System.out.println("  ----------------------------------------");
        System.out.printf("  Class Average: %.2f%%%n", classAverage);
    }

    /**
     * Prints a numbered list of students and prompts the user to select one.
     * @return the selected Student, or null if selection was invalid
     */
    private static Student selectStudent() {
        System.out.println("  Students:");

        // Loop to print all students with index numbers
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("    %d. %s (ID: %s)%n",
                    i + 1, students.get(i).getName(), students.get(i).getStudentId());
        }

        int index = readInt("  Select student number: ") - 1;

        // Conditional: validate selection range
        if (index < 0 || index >= students.size()) {
            System.out.println("  Invalid selection.");
            return null;
        }

        return students.get(index);
    }

    /**
     * Reads an integer from the user, handling invalid input gracefully.
     * @param prompt the message to display before reading input
     * @return the integer entered by the user, or -1 on invalid input
     */
    private static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("  (Invalid number, defaulting to -1)");
            return -1;
        }
    }

    /**
     * Reads a double from the user, handling invalid input gracefully.
     * @param prompt the message to display before reading input
     * @return the double entered by the user, or 0.0 on invalid input
     */
    private static double readDouble(String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  (Invalid number, defaulting to 0.0)");
            return 0.0;
        }
    }

    /**
     * Loads a set of pre-built demo students and assessments so the
     * user can explore the app without entering data from scratch.
     */
    private static void loadDemoData() {
        Student alice = new Student("Alice Johnson", "S001");
        alice.addAssessment(new Assignment("Homework 1", 88, 100));
        alice.addAssessment(new Assignment("Homework 2", 95, 100));
        alice.addAssessment(new Exam("Midterm Exam", 74, 100, 1.5));
        alice.addAssessment(new Exam("Final Exam", 82, 100, 2.0));
        students.add(alice);

        Student bob = new Student("Bob Smith", "S002");
        bob.addAssessment(new Assignment("Homework 1", 70, 100));
        bob.addAssessment(new Assignment("Homework 2", 65, 100));
        bob.addAssessment(new Exam("Midterm Exam", 60, 100, 1.5));
        bob.addAssessment(new Exam("Final Exam", 55, 100, 2.0));
        students.add(bob);

        Student carol = new Student("Carol White", "S003");
        carol.addAssessment(new Assignment("Homework 1", 100, 100));
        carol.addAssessment(new Assignment("Homework 2", 98, 100));
        carol.addAssessment(new Exam("Midterm Exam", 95, 100, 1.5));
        carol.addAssessment(new Exam("Final Exam", 97, 100, 2.0));
        students.add(carol);

        System.out.println("Demo data loaded: 3 students with assessments ready to view.\n");
    }
}
