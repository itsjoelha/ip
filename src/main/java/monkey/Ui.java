package monkey;
import monkey.task.Task;

public class Ui {
    public static final String DASH_LINE = "------------------------------------------------------";

    public static void printWelcomeMessage() {
        System.out.println(DASH_LINE);
        System.out.println("  __  __              _        \n" +
                " |  \\/  | ___  _ __  | | _____ __     __\n" +
                " | |\\/| |/ _ \\| '_ \\ | |/ / _ \\\\ \\   / /\n" +
                " | |  | | (_) | | | ||   <  __/ \\ \\_/ / \n" +
                " |_|  |_|\\___/|_| |_||_|\\_\\___|  \\   /\n" +
                "                                 \\_/");
        System.out.println("Hello! I'm Monkey!");
        System.out.println("What can I do for you?");
        System.out.println(DASH_LINE);
    }

    public static void printExitMessage() {
        System.out.println(DASH_LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(DASH_LINE);
    }

    public static void printInvalidCommand() {
        System.out.println(DASH_LINE);
        System.out.println("Oh no! I do not understand the command.");
        System.out.println(DASH_LINE);
    }

    public static void printInvalidTaskNumber() {
        System.out.println(DASH_LINE);
        System.out.println("Oh no! The task number is invalid.");
        System.out.println(DASH_LINE);
    }

    public static void printTaskList(java.util.List<Task> tasks) {
        System.out.println(DASH_LINE);
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
        } else {
            System.out.println("Here are the tasks in your list: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println(DASH_LINE);
    }

    public static void printTaskAdded(Task task, int totalTasks) {
        System.out.println(DASH_LINE);
        System.out.println("Got it. I've added this task: ");
        System.out.println("   " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(DASH_LINE);
    }

    public static void printTaskDeleted(Task task, int totalTasks) {
        System.out.println(DASH_LINE);
        System.out.println("OK. I've deleted this task: ");
        System.out.println("   " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(DASH_LINE);
    }

    public static void printTaskMarked(Task task) {
        System.out.println(DASH_LINE);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println("   " + task);
        System.out.println(DASH_LINE);
    }

    public static void printTaskUnmarked(Task task) {
        System.out.println(DASH_LINE);
        System.out.println("OK, I've marked this task as not done yet: ");
        System.out.println("   " + task);
        System.out.println(DASH_LINE);
    }
}
