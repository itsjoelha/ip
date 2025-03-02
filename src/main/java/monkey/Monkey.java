package monkey;

import java.util.ArrayList;
import java.util.Scanner;
import monkey.task.Task;
import monkey.task.Todo;
import monkey.task.Deadline;
import monkey.task.Event;
import java.util.ArrayList;
import java.util.Arrays;

public class Monkey {
    private TaskList taskList;

    public Monkey() {
        Storage storage = new Storage("data/monkey.txt");
        taskList = new TaskList(storage);
    }

    // Adds a task: todo, deadline, or event based on input
    public void addTask(String input) throws MonkeyException {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new MonkeyException("Oh no! The description of a " + parts[0] + " cannot be empty.");
        }

        String type = parts[0];
        String description = parts[1];

        Task newTask = null;

        if (type.equals("todo")) {
            newTask = new Todo(description);
        } else if (type.equals("deadline")) {
            String[] deadlineParts = description.split(" /by ", 2);
            if (deadlineParts.length < 2 || deadlineParts[1].trim().isEmpty()) {
                throw new MonkeyException("Oh no! Deadlines must have the format: deadline <task> /by <date>");
            }
            newTask = new Deadline(deadlineParts[0], deadlineParts[1]);
        } else if (type.equals("event")) {
            String[] eventParts = description.split(" /from | /to ", 3);
            if (eventParts.length < 3 || eventParts[1].trim().isEmpty() || eventParts[2].trim().isEmpty()) {
                throw new MonkeyException("Oh no! Events must have the format: event <task> /from <start> /to <end>");
            }
            newTask = new Event(eventParts[0], eventParts[1], eventParts[2]);
        } else {
            throw new MonkeyException("Oh no! This command is invalid.");
        }
        taskList.addTask(newTask);
    }

    public void deleteTask(int taskNumber) {
        taskList.deleteTask(taskNumber);
    }

    public void list() {
        taskList.listTasks();
    }

    public void markTask(int taskNumber) {
        taskList.markTask(taskNumber);
    }

    public void unmarkTask(int taskNumber) {
        taskList.unmarkTask(taskNumber);
    }

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Scanner in = new Scanner(System.in);
        String input;

        Ui.printWelcomeMessage();

        while (true) {
            input = in.nextLine().trim();
            Parser.parse(input, monkey);
        }
    }
}