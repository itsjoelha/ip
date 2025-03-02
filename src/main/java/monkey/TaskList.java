package monkey;

import java.util.ArrayList;
import monkey.task.Task;

public class TaskList {
    private ArrayList<Task> tasks;
    private Storage storage;

    public TaskList(Storage storage) {
        this.storage = storage;
        this.tasks = storage.loadTasks(); // Load tasks from storage
    }

    public void addTask(Task task) {
        tasks.add(task);
        storage.saveTasks(tasks);
        Ui.printTaskAdded(task, tasks.size());
    }

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

    public void listTasks() {
        Ui.printTaskList(tasks);
    }

    public void markTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markDone();
            storage.saveTasks(tasks);
            Ui.printTaskMarked(tasks.get(taskNumber - 1));
        } else {
            Ui.printInvalidTaskNumber();
        }
    }

    public void unmarkTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).unmarkDone();
            storage.saveTasks(tasks);
            Ui.printTaskUnmarked(tasks.get(taskNumber - 1));
        } else {
            Ui.printInvalidTaskNumber();
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

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
