import java.util.Scanner;

public class Monkey {
    public static final String DASH_LINE = "--------------------------------";
    Task[] tasks = new Task[100];
    int taskCounter = 0;

    // Adds a task: todo, deadline, or event based on input
    public void addTask(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            printInvalidCommand();
            return;
        }

        String type = parts[0];
        String description = parts[1];

        Task newTask = null;

        if (type.equals("todo")) {
            newTask = new Todo(description);
        } else if (type.equals("deadline")) {
            String[] deadlineParts = description.split(" /by ", 2);
            if (deadlineParts.length < 2) {
                printInvalidCommand();
                return;
            }
            newTask = new Deadline(deadlineParts[0], deadlineParts[1]);
        } else if (type.equals("event")) {
            String[] eventParts = description.split(" /from | /to ", 3);
            if (eventParts.length < 3) {
                printInvalidCommand();
                return;
            }
            newTask = new Event(eventParts[0], eventParts[1], eventParts[2]);
        } else {
            printInvalidCommand();
            return;
        }

        tasks[taskCounter] = newTask;
        taskCounter++;
        System.out.println(DASH_LINE);
        System.out.println("Got it. I've added this task: ");
        System.out.println("   " + newTask);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
        System.out.println(DASH_LINE);
    }

    private static void printInvalidCommand() {
        System.out.println(DASH_LINE);
        System.out.println("Oh no! This command is invalid.");
        System.out.println(DASH_LINE);
    }

    public void list() {
        System.out.println(DASH_LINE);
        if (taskCounter == 0) {
            System.out.println("No tasks yet.");
        } else {
            System.out.println("Here are the tasks in your list: ");
            for (int i = 0; i < taskCounter; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
        System.out.println(DASH_LINE);
    }

    public void markTask(int taskNumber) {
        System.out.println(DASH_LINE);
        if (taskNumber > 0 && taskNumber <= taskCounter) {
            tasks[taskNumber - 1].markDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println("   " + tasks[taskNumber - 1]);
        } else {
            System.out.println("Invalid task number.");
        }
        System.out.println(DASH_LINE);
    }

    public void unmarkTask(int taskNumber) {
        System.out.println(DASH_LINE);
        if (taskNumber > 0 && taskNumber <= taskCounter) {
            tasks[taskNumber - 1].unmarkDone();
            System.out.println("OK, I've marked this task as not done yet: ");
            System.out.println("   " + tasks[taskNumber - 1]);
        } else {
            System.out.println("Invalid task number.");
        }
        System.out.println(DASH_LINE);
    }

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Scanner in = new Scanner(System.in);
        String input;

        printWelcomeMessage();

        while (true) {
            input = in.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                printExitMessage();
                break;
            } else if (input.equalsIgnoreCase("list")) {
                monkey.list();
            } else if (input.startsWith("mark ")) {
                int taskNumber = Integer.parseInt(input.substring(5).trim());
                monkey.markTask(taskNumber);
            } else if (input.startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(input.substring(7).trim());
                monkey.unmarkTask(taskNumber);
            } else {
                monkey.addTask(input);
            }
        }
    }

    private static void printExitMessage() {
        System.out.println(DASH_LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(DASH_LINE);
    }

    private static void printWelcomeMessage() {
        System.out.println(DASH_LINE);
        System.out.println("Hello! I'm Monkey!");
        System.out.println("What can I do for you?");
        System.out.println(DASH_LINE);
    }
}
