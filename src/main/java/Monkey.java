import java.util.Scanner;

public class Monkey {
    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Hello! I'm Monkey!");
        System.out.println("What can I do for you?");
        System.out.println("--------------------------------");

        while (true) {
            input = in.nextLine();
            if (input.equals("bye")) {
                System.out.println("--------------------------------");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("--------------------------------");
                break;
            }
            System.out.println(input);
        }
    }
}
