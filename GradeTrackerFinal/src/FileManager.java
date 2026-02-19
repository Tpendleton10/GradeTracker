import java.io.*;
import java.util.ArrayList;

/**
 * Handles reading and writing student grade data to/from a CSV file.
 * Satisfies the "read and write to a file" requirement.
 */
public class FileManager {

    private static final String FILE_PATH = "grades.csv";
    private static final String HEADER = "Name,StudentID,NumAssessments,WeightedAverage";

    /**
     * Saves a list of students to the CSV file.
     * Overwrites the file each time it is called.
     * @param students the list of Student objects to save
     */
    public static void saveToFile(ArrayList<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            writer.println(HEADER);
            for (Student s : students) {
                writer.println(s.toCSV());
            }
            System.out.println("  Data saved to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("  Error saving file: " + e.getMessage());
        }
    }

    /**
     * Reads and displays the contents of the saved CSV file.
     * Does not reconstruct Student objects (summary view only).
     */
    public static void loadAndDisplay() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("  No saved data file found (" + FILE_PATH + ").");
            return;
        }

        System.out.println("\n--- Saved Grade Report (" + FILE_PATH + ") ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("  Error reading file: " + e.getMessage());
        }
    }
}
