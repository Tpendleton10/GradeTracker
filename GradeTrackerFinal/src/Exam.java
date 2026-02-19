/**
 * Represents an exam or quiz.
 * Extends Assessment and adds a weight multiplier for final grade calculation.
 */
public class Exam extends Assessment {

    private double weight; // e.g., 1.5 means this exam counts 1.5x

    /**
     * Constructor for Exam.
     * @param name     the exam name
     * @param score    the score earned
     * @param maxScore the maximum possible score
     * @param weight   the weight multiplier for this exam
     */
    public Exam(String name, double score, double maxScore, double weight) {
        super(name, score, maxScore);
        this.weight = weight;
    }

    /**
     * Returns the weight of this exam.
     * @return the weight multiplier
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the type label for this assessment.
     * @return "Exam"
     */
    @Override
    public String getType() {
        return "Exam";
    }

    /**
     * Returns a formatted string that includes the weight.
     * @return summary string with weight
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" [Weight: %.1fx]", weight);
    }
}
