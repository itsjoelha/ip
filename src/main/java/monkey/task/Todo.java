package monkey.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description, "todo");
    }

    @Override
    public String toFileString() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
