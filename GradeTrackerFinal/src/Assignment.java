/**
 * Represents a homework or project assignment.
 * Extends Assessment and inherits its fields and methods.
 */
public class Assignment extends Assessment {

    /**
     * Constructor for Assignment.
     * @param name     the assignment name
     * @param score    the score earned
     * @param maxScore the maximum possible score
     */
    public Assignment(String name, double score, double maxScore) {
        super(name, score, maxScore);
    }

    /**
     * Returns the type label for this assessment.
     * @return "Assignment"
     */
    @Override
    public String getType() {
        return "Assignment";
    }
}
