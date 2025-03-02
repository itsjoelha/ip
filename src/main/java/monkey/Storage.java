package monkey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import monkey.task.Task;
import monkey.task.Todo;
import monkey.task.Deadline;
import monkey.task.Event;

/**
 * The Storage class handles reading and writing tasks to a file for storage.
 * It allows tasks to be saved and loaded from a specified file.
 */
public class Storage {
    /** The file path where tasks are stored. */
    private String filePath;

    /** The directory path where the file is located. */
    private String directoryPath;

    /**
     * Creates a Storage object with the specified file path.
     * @param filePath The path to the file where the tasks are stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        this.directoryPath = new File(filePath).getParent();
    }

    /**
     * Load tasks from the file into an ArrayList<Task>.
     * Returns empty list if the file does not exist.
     * @return An ArrayList containing the tasks loaded from the file.
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return tasks; // No file yet, return empty list
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = parseTaskFromLine(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }

    /**
     * Saves the given list of tasks to the file.
     * Creates a directory if it does not exist.
     * @param tasks The list of tasks to be saved.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try (FileWriter fw = new FileWriter(filePath)) {
                for (Task task : tasks) {
                    fw.write(task.toFileString() + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Parses a line from the storage file and converts it to a Task object.
     * @param line The line to be parsed.
     * @return A Task object if the line is valid, otherwise null.
     */
    private Task parseTaskFromLine(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) return null;

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task task;
        if (type.equals("T")) {
            task = new Todo(description);
        } else if (type.equals("D") && parts.length == 4) {
            task = new Deadline(description, parts[3]);
        } else if (type.equals("E") && parts.length == 5) {
            task = new Event(description, parts[3], parts[4]);
        } else {
            return null;
        }

        if (isDone) task.markDone();
        return task;
    }
}
