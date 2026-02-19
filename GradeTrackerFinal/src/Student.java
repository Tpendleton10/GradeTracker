import java.util.ArrayList;

/**
 * Represents a student with a name, ID, and a list of assessments.
 * Uses ArrayList from the Java Collections Framework.
 */
public class Student {

    private String name;
    private String studentId;
    private ArrayList<Assessment> assessments; // Java Collections Framework

    /**
     * Constructor for Student.
     * @param name      the student's full name
     * @param studentId a unique student ID string
     */
    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.assessments = new ArrayList<>();
    }

    /** @return the student's name */
    public String getName() {
        return name;
    }

    /** @return the student's ID */
    public String getStudentId() {
        return studentId;
    }

    /** @return the list of assessments */
    public ArrayList<Assessment> getAssessments() {
        return assessments;
    }

    /**
     * Adds an assessment to the student's record.
     * @param assessment the Assessment to add
     */
    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

    /**
     * Calculates the student's average percentage across all assessments.
     * Exams are weighted by their weight multiplier.
     * @return the weighted average percentage, or 0.0 if no assessments exist
     */
    public double calculateAverage() {
        if (assessments.isEmpty()) return 0.0;

        double totalWeightedScore = 0.0;
        double totalWeight = 0.0;

        for (Assessment a : assessments) {
            double weight = (a instanceof Exam) ? ((Exam) a).getWeight() : 1.0;
            totalWeightedScore += a.getPercentage() * weight;
            totalWeight += weight;
        }

        return totalWeightedScore / totalWeight;
    }

    /**
     * Converts a numeric average to a letter grade.
     * @param average the numeric average (0.0 - 100.0)
     * @return the corresponding letter grade as a String
     */
    public String getLetterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    /**
     * Prints a full report of this student's grades to the console.
     */
    public void printReport() {
        System.out.println("\n--- Report for " + name + " (ID: " + studentId + ") ---");
        if (assessments.isEmpty()) {
            System.out.println("  No assessments recorded.");
        } else {
            for (Assessment a : assessments) {
                System.out.println("  " + a);
            }
            double avg = calculateAverage();
            System.out.printf("  Weighted Average: %.2f%% | Letter Grade: %s%n",
                    avg, getLetterGrade(avg));
        }
    }

    /**
     * Returns a one-line CSV-formatted string for file storage.
     * Format: name,studentId,assessmentCount,weightedAverage
     * @return CSV string
     */
    public String toCSV() {
        return String.format("%s,%s,%d,%.2f",
                name, studentId, assessments.size(), calculateAverage());
    }
}
