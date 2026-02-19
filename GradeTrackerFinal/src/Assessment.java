/**
 * Abstract base class for all types of assessments.
 * Subclasses (Assignment, Exam) extend this and implement GradedItem.
 * Demonstrates use of 'abstract' and 'extends' keywords.
 */
public abstract class Assessment implements GradedItem {

    protected String name;
    protected double score;
    protected double maxScore;

    /**
     * Constructor for Assessment.
     * @param name     the name of the assessment
     * @param score    the score earned
     * @param maxScore the maximum possible score
     */
    public Assessment(String name, double score, double maxScore) {
        this.name = name;
        this.score = score;
        this.maxScore = maxScore;
    }

    /** @return the name of this assessment */
    @Override
    public String getName() {
        return name;
    }

    /** @return the score earned */
    @Override
    public double getScore() {
        return score;
    }

    /** @return the maximum possible score */
    @Override
    public double getMaxScore() {
        return maxScore;
    }

    /**
     * Abstract method that subclasses must implement to return
     * a label for the type of assessment (e.g., "Assignment", "Exam").
     * @return type label string
     */
    public abstract String getType();

    /**
     * Returns a formatted string summary of this assessment.
     * @return summary string
     */
    @Override
    public String toString() {
        return String.format("[%s] %s: %.1f / %.1f (%.1f%%)",
                getType(), name, score, maxScore, getPercentage());
    }
}
