package monkey;
import monkey.task.Task;

/**
 * The Ui class handles all user interactions, including printing messages
 * and displaying tasks-related information.
 */
public class Ui {
    /** A horizontal line separator for output formatting. */
    public static final String DASH_LINE = "------------------------------------------------------";

    /**
     * Prints the welcome message upon starting application.
     */
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

    /**
     * Prints the exit message when application is closed.
     */
    public static void printExitMessage() {
        System.out.println(DASH_LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(DASH_LINE);
    }

    /**
     * Prints an error message for an invalid command.
     */
    public static void printInvalidCommand() {
        System.out.println(DASH_LINE);
        System.out.println("Oh no! I do not understand the command.");
        System.out.println(DASH_LINE);
    }

    /**
     * Prints an error message when an invalid task number is provided.
     */
    public static void printInvalidTaskNumber() {
        System.out.println(DASH_LINE);
        System.out.println("Oh no! The task number is invalid.");
        System.out.println(DASH_LINE);
    }

    /**
     * Displays the list of tasks.
     * @param tasks The list of tasks to display.
     */
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

    /**
     * Prints a message when a new task is added.
     * @param task The task that was added.
     * @param totalTasks The total number of tasks updated.
     */
    public static void printTaskAdded(Task task, int totalTasks) {
        System.out.println(DASH_LINE);
        System.out.println("Got it. I've added this task: ");
        System.out.println("   " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(DASH_LINE);
    }

    /**
     * Prints a message when a task is deleted.
     * @param task The task that was deleted.
     * @param totalTasks The total number of tasks updated.
     */
    public static void printTaskDeleted(Task task, int totalTasks) {
        System.out.println(DASH_LINE);
        System.out.println("OK. I've deleted this task: ");
        System.out.println("   " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(DASH_LINE);
    }

    /**
     * Prints a message when a task is marked as done.
     * @param task The task that was marked as done.
     */
    public static void printTaskMarked(Task task) {
        System.out.println(DASH_LINE);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println("   " + task);
        System.out.println(DASH_LINE);
    }

    /**
     * Prints a message when a task is unmarked.
     * @param task The task that was unmarked.
     */
    public static void printTaskUnmarked(Task task) {
        System.out.println(DASH_LINE);
        System.out.println("OK, I've marked this task as not done yet: ");
        System.out.println("   " + task);
        System.out.println(DASH_LINE);
    }
}
