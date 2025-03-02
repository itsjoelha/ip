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
    public static final String DASH_LINE = "------------------------------------------------------";
    private ArrayList<Task> tasks;
    private Storage storage;

    public Monkey() {
        storage = new Storage("data/monkey.txt");  // Initialize storage
        tasks = storage.loadTasks();  // Load tasks from file
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

        tasks.add(newTask);
        storage.saveTasks(tasks);
        System.out.println(DASH_LINE);
        System.out.println("Got it. I've added this task: ");
        System.out.println("   " + newTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(DASH_LINE);
    }

    public void deleteTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            System.out.println(DASH_LINE);
            System.out.println("OK. I've deleted this task: ");
            System.out.println("   " + tasks.get(taskNumber - 1));

            tasks.remove(taskNumber - 1);

            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            System.out.println(DASH_LINE);
            storage.saveTasks(tasks);
        } else {
            Ui.printInvalidTaskNumber();
        }
    }

    public void list() {
        Ui.printTaskList(tasks);
    }

    public void markTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            System.out.println(DASH_LINE);
            tasks.get(taskNumber - 1).markDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println("   " + tasks.get(taskNumber - 1));
            System.out.println(DASH_LINE);
            storage.saveTasks(tasks);
        } else {
            Ui.printInvalidTaskNumber();
        }
    }

    public void unmarkTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            System.out.println(DASH_LINE);
            tasks.get(taskNumber - 1).unmarkDone();
            System.out.println("OK, I've marked this task as not done yet: ");
            System.out.println("   " + tasks.get(taskNumber - 1));
            System.out.println(DASH_LINE);
            storage.saveTasks(tasks);
        } else {
            Ui.printInvalidTaskNumber();
        }
    }

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Scanner in = new Scanner(System.in);
        String input;

        Ui.printWelcomeMessage();

        while (true) {
            input = in.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                Ui.printExitMessage();
                break;
            } else if (input.equalsIgnoreCase("list")) {
                monkey.list();
            } else if (input.matches("^mark$") || input.matches("^unmark$") || (input.matches("^delete$"))) {
                Ui.printInvalidTaskNumber();
            } else if (input.matches("^mark \\d+$")){
                int taskNumber = Integer.parseInt(input.split(" ")[1]);
                monkey.markTask(taskNumber);
            } else if (input.matches("^unmark \\d+$")) {
                int taskNumber = Integer.parseInt(input.split(" ")[1]);
                monkey.unmarkTask(taskNumber);
            } else if (input.matches("delete \\d+$")) {
                int taskNumber = Integer.parseInt(input.split(" ")[1]);
                monkey.deleteTask(taskNumber);
            } else if (input.matches("^(todo|deadline|event)( .+)?$")) {
                try {
                    monkey.addTask(input);
                } catch (MonkeyException e) {
                    System.out.println(DASH_LINE);
                    System.out.println(e.getMessage());
                    System.out.println(DASH_LINE);
                }
            } else {
                Ui.printInvalidCommand();
            }
        }
    }
}

