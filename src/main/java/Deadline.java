public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description, "deadline");
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + "[" + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }
}
