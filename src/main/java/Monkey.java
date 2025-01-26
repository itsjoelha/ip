import java.util.Scanner;

public class Monkey {
    String[] tasks = new String[100];
    int taskCounter = 0;

    public void toAdd(String input) {
        tasks[taskCounter] = input;
        taskCounter++;
        System.out.println("added: " + input);
    }

    public void list() {
        if (taskCounter == 0) {
            System.out.println("No tasks yet.");
        } else {
            for (int i = 0; i < taskCounter; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
    }

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        String input;
        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Hello! I'm Monkey!");
        System.out.println("What can I do for you?");
        System.out.println("--------------------------------");

        while (true) {
            input = in.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("--------------------------------");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("--------------------------------");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                monkey.list();
            } else {
                monkey.toAdd(input);
            }
        }
    }
}
