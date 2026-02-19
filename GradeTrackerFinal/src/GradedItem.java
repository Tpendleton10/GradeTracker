/**
 * GradedItem interface - defines the contract for any item that can be graded.
 * Used with the 'implements' keyword in Assignment and Exam classes.
 */
public interface GradedItem {

    /**
     * Returns the name/description of the graded item.
     * @return the item name
     */
    String getName();

    /**
     * Returns the numeric score for this graded item.
     * @return the score as a double
     */
    double getScore();

    /**
     * Returns the maximum possible score for this graded item.
     * @return the maximum score as a double
     */
    double getMaxScore();

    /**
     * Calculates and returns the percentage score.
     * @return percentage (0.0 - 100.0)
     */
    default double getPercentage() {
        if (getMaxScore() == 0) return 0;
        return (getScore() / getMaxScore()) * 100.0;
    }
}
