package monkey;

import java.util.ArrayList;
import monkey.task.Task;

/**
 * The TaskList class manages a list of tasks, providing functionality to add, delete,
 * mark, unmark, list, and find tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;
    private Storage storage;

    /**
     * Creates a TaskList with tasks loaded from storage.
     * @param storage The storage system handling tasks.
     */
    public TaskList(Storage storage) {
        this.storage = storage;
        this.tasks = storage.loadTasks();
    }

    /**
     * Adds a task to the task list and saves it to storage.
     * @param task The task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
        storage.saveTasks(tasks);
        Ui.printTaskAdded(task, tasks.size());
    }

    /**
     * Deletes a task from the task list.
     * @param taskNumber The index of the task to delete.
     */
    public void deleteTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task removedTask = tasks.get(taskNumber - 1);
            tasks.remove(taskNumber - 1);
            Ui.printTaskDeleted(removedTask, tasks.size());
            storage.saveTasks(tasks);
        } else {
            Ui.printInvalidTaskNumber();
        }
    }

    /**
     * Lists all the tasks in the task list.
     */
    public void listTasks() {
        Ui.printTaskList(tasks);
    }

    /**
     * Marks a task as completed.
     * @param taskNumber The index of the task to mark as completed.
     */
    public void markTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markDone();
            storage.saveTasks(tasks);
            Ui.printTaskMarked(tasks.get(taskNumber - 1));
        } else {
            Ui.printInvalidTaskNumber();
        }
    }

    /**
     * Unmarks a completed task.
     * @param taskNumber The index of the task to unmark.
     */
    public void unmarkTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).unmarkDone();
            storage.saveTasks(tasks);
            Ui.printTaskUnmarked(tasks.get(taskNumber - 1));
        } else {
            Ui.printInvalidTaskNumber();
        }
    }

    /**
     * Returns the list of tasks.
     * @return The list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Finds and prints tasks that contain the given keyword.
     * @param keyword The search keyword.
     */
    public void findTask(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).toString().contains(keyword)) {
                matchingTasks.add(tasks.get(i));
            }
        }

        if (matchingTasks.isEmpty()) {
            System.out.println(Ui.DASH_LINE);
            System.out.println("No matching tasks found.");
            System.out.println(Ui.DASH_LINE);
        } else {
            System.out.println(Ui.DASH_LINE);
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + "." + matchingTasks.get(i));
            }
            System.out.println(Ui.DASH_LINE);
        }
    }
}
