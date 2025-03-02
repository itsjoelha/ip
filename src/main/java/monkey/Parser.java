package monkey;

/**
 * The Parser class is responsible for interpreting user commands and executing
 * the corresponding actions in the Monkey task manager.
 */
public class Parser {
    /**
     * Parses the user input and executes the corresponding command.
     * @param input The command entered by the user.
     * @param monkey The Monkey instance that manages tasks.
     */
    public static void parse(String input, Monkey monkey) {
        try {
            if (input.equalsIgnoreCase("bye")) {
                Ui.printExitMessage();
                System.exit(0);
            } else if (input.equalsIgnoreCase("list")) {
                monkey.list();
            } else if (input.matches("^mark$") || input.matches("^unmark$") || (input.matches("^delete$"))) {
                Ui.printInvalidTaskNumber();
            } else if (input.matches("^mark \\d+$")) {
                int taskNumber = Integer.parseInt(input.split(" ")[1]);
                monkey.markTask(taskNumber);
            } else if (input.matches("^unmark \\d+$")) {
                int taskNumber = Integer.parseInt(input.split(" ")[1]);
                monkey.unmarkTask(taskNumber);
            } else if (input.matches("delete \\d+$")) {
                int taskNumber = Integer.parseInt(input.split(" ")[1]);
                monkey.deleteTask(taskNumber);
            } else if (input.matches("^(todo|deadline|event)( .+)?$")) {
                monkey.addTask(input);
            } else if (input.startsWith("find ")) {
                String keyword = input.substring(5).trim();
                monkey.findTask(keyword);
            } else {
                Ui.printInvalidCommand();
            }
        } catch (MonkeyException e) {
            System.out.println(Ui.DASH_LINE);
            System.out.println(e.getMessage());
            System.out.println(Ui.DASH_LINE);
        }
    }
}
