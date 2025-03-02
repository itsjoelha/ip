package monkey;

import java.util.ArrayList;
import java.util.Scanner;
import monkey.task.Task;
import monkey.task.Todo;
import monkey.task.Deadline;
import monkey.task.Event;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Monkey class represents a task manager that allows users to add, delete, list,
 * mark, unmark, and find tasks. It interacts with a TaskList for managing tasks.
 */
public class Monkey {
    private TaskList taskList;

    /**
     * Initializes a Monkey instance with a storage system.
     */
    public Monkey() {
        Storage storage = new Storage("data/monkey.txt");
        taskList = new TaskList(storage);
    }

    /**
     * Adds a task to the task list based on the user input.
     * @param input User input indicating the task type and description.
     * @throws MonkeyException If the input format is invalid.
     */
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

    /**
     * Deletes a task by its task number.
     * @param taskNumber The index of the task to delete.
     */
    public void deleteTask(int taskNumber) {
        taskList.deleteTask(taskNumber);
    }

    /**
     * Lists all the tasks in the task list.
     */
    public void list() {
        taskList.listTasks();
    }

    /**
     * Marks a task as completed.
     * @param taskNumber The index of the task to mark.
     */
    public void markTask(int taskNumber) {
        taskList.markTask(taskNumber);
    }

    /**
     * Unmarks a completed task.
     * @param taskNumber The index of the task to unmark.
     */
    public void unmarkTask(int taskNumber) {
        taskList.unmarkTask(taskNumber);
    }

    /**
     * Finds tasks containing the given keyword.
     * @param keyword The search keyword.
     */
    public void findTask(String keyword) {
        taskList.findTask(keyword);
    }

    /**
     * The main method that runs the Monkey task manager & handles user input.
     * @param args Command Line arguments.
     */
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