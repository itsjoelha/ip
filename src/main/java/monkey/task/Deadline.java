package monkey.task;

/**
 * This represents a task with a deadline.
 * A Deadline task has a description and a due date ("by").
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Creates a Deadline task with the specified description and due date.
     * @param description The description of the deadline task.
     * @param by The due date of the task.
     */
    public Deadline(String description, String by) {
        super(description, "deadline");
        this.by = by;
    }

    /**
     * Returns a string representation of the deadline task for display in the task list.
     * The format includes the task type `[D]`, status `[X/ ]`, description, and due date.
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + "[" + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }

    /**
     * Returns a formatted string representation of the deadline task for file storage.
     * The format follows: `D | isDone | description | by`.
     * @return A string formatted for saving the deadline task to a file.
     */
    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
