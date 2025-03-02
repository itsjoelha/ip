package monkey.task;

/**
 * This represents a to-do task.
 * A To-do task has only a description without a specific deadline or time period.
 */
public class Todo extends Task {
    /**
     * Creates a To-do task with the specified description.
     * @param description The description of the to-do task.
     */
    public Todo(String description) {
        super(description, "todo");
    }

    /**
     * Returns a formatted string representation of the to-do task for file storage.
     * The format follows: `T | isDone | description`.
     * @return A string formatted for saving the to-do task to a file.
     */
    @Override
    public String toFileString() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
