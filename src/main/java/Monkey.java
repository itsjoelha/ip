import java.util.Scanner;

public class Monkey {
    Task[] tasks = new Task[100];
    int taskCounter = 0;

    public void toAdd(String input) {
        tasks[taskCounter] = new Task(input);
        taskCounter++;
        System.out.println("--------------------------------");
        System.out.println("added: " + input);
        System.out.println("--------------------------------");
    }

    public void list() {
        if (taskCounter == 0) {
            System.out.println("--------------------------------");
            System.out.println("No tasks yet.");
            System.out.println("--------------------------------");
        } else {
            System.out.println("--------------------------------");
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < taskCounter; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
            System.out.println("--------------------------------");
        }
    }

    public void markTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= taskCounter) {
            tasks[taskNumber - 1].markDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("   " + tasks[taskNumber - 1]);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void unmarkTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= taskCounter) {
            tasks[taskNumber - 1].unmarkDone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println("   " + tasks[taskNumber - 1]);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("--------------------------------");
        System.out.println("Hello! I'm Monkey!");
        System.out.println("What can I do for you?");
        System.out.println("--------------------------------");

        while (true) {
            input = in.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("--------------------------------");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("--------------------------------");
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
                monkey.toAdd(input);
            }
        }
    }
}
