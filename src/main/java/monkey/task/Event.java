package monkey.task;

/**
 * This represents an event task that occurs within a specific time period.
 * An Event task has a description, a start time ("from"), and an end time ("to").
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Creates an Event task with the specified description, start time, and end time.
     * @param description The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description, "event");
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the event task for display in the task list.
     * The format includes the task type `[E]`, status `[X/ ]`, description, start time, and end time.
     * @return A formatted string representing the event task.
     */
    @Override
    public String toString() {
        return "[E]" + "[" + getStatusIcon() + "] " + description + " (from: " + from + " to: " + to + ")";
    }

    /**
     * Returns a formatted string representation of the event task for file storage.
     * The format follows: `E | isDone | description | from | to`.
     * @return A string formatted for saving the event task to a file.
     */
    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}
