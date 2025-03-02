# Monkey User Guide 🐵

## 1. Introduction
Monkey is a simple yet powerful task management tool that helps you keep track of your to-dos, deadlines, and events. With Monkey, you can effortlessly add, mark, unmark, delete, and list tasks while also searching for specific tasks using keywords. Monkey ensures that your tasks are saved automatically, so you never lose track of what needs to be done.

## 2. Getting Started

### Launching the Application

Simply run the program to start using Monkey. You will be greeted with:

```
    __  __              _        
   |  \/  | ___  _ __  | | _____ __     __
   | |\/| |/ _ \| '_ \ | |/ / _ \\ \   / /
   | |  | | (_) | | | ||   <  __/ \ \_/ / 
   |_|  |_|\___/|_| |_||_|\_\___|  \   /
                                   \_/
   
   Hello! I'm Monkey!
   What can I do for you?
   ```
Now you can start entering commands to manage your tasks!

### Exiting the Application

To exit Monkey, type: `bye`
```
Bye. Hope to see you again soon!
```
The application will close automatically.

## 3. Adding Tasks

Monkey supports three types of tasks:

### 3.1 Adding a To-Do

A to-do task is a simple task with no deadline or specific time.

To add a to-do, type: `todo TASK_DESCRIPTION`. For example, `todo Buy toothpaste`.

```
Got it. I've added this task: 
   [T][ ] Buy toothpaste
Now you have 1 tasks in the list.
```
### 3.2 Adding a Deadline

A deadline task must be completed by a specific date.

To add a deadline, type: `deadline TASK_DESCRIPTION /by DATE`. For example, `deadline Finish Math HW /by Mon`

```
Got it. I've added this task: 
   [D][ ] Finish Math HW (by: Mon)
Now you have 2 tasks in the list.
```

### 3.3 Adding an Event

An event task occurs over a period of time.

To add an event, type: `event TASK_DESCRIPTION /from START /to END`. For example, `event Project Meeting /from Thu 3pm /to 5pm`.

```
Got it. I've added this task: 
   [E][ ] Project Meeting (from: Thu 3pm to: 5pm)
Now you have 3 tasks in the list.
```

## 4. Listing All Tasks

To see all tasks in your list, use the `list` command.

```
Here are the tasks in your list: 
1. [T][ ] Buy toothpaste
2. [D][ ] Finish Math HW (by: Mon)
3. [E][ ] Project Meeting (from: Thu 3pm to: 5pm)
```

If there are no tasks:

```
No tasks yet.
```

## 5. Deleting Tasks

To remove a task, type: `delete TASK_NUMBER`. For example, `delete 1`.

```
OK. I've deleted this task: 
   [T][ ] Buy toothpaste
Now you have 2 tasks in the list.
```

## 6. Marking a Task as Done

Once you complete a task, you can mark it as done.

You can mark a task by typing: `mark TASK_NUMBER`. For example, `mark 2`.

```
Nice! I've marked this task as done: 
   [E][X] Project Meeting (from: Thu 3pm to: 5pm)
```

## 7. Unmarking a Task

If you accidentally mark a task as done, you can undo it.

To do so, type: `unmark TASK_NUMBER`. For example, `unmark 2`.

```
OK, I've marked this task as not done yet: 
   [E][ ] Project Meeting (from: Thu 3pm to: 5pm)
```

## 8. Finding Tasks by Keyword

To search for a task by keyword, use the `find` command.

Type `find KEYWORD`. For example, `find Math`.

```
Here are the matching tasks in your list:
1.[D][ ] Finish Math HW (by: Mon)
```

If no tasks match:

```
No matching tasks found.
```

## 9. Handling Invalid Commands

If an invalid command is entered, Monkey will notify you.

For example, type `randomCommand`.

```
Oh no! I do not understand the command.
```

## 10. Task Storage

Monkey automatically saves your tasks to a file. Your task list will be available when you restart the program.

## 11. Summary of Commands

| **Command** | **Description**           | **Example**                                   |
|-------------|---------------------------|-----------------------------------------------|
| `todo`      | Adds a to-do task         | `todo Buy toothpaste`                         |
| `deadline`  | Adds a deadline task      | `deadline Finish Math HW /by Mon`             |
| `event`     | Adds an event task        | `event Project Meeting /from Thu 3pm /to 5pm` |
| `list`      | Displays all tasks        | `list`                                        |
| `delete`    | Deletes a task            | `delete 1`                                    |
| `mark`      | Marks a task as done      | `mark 1`                                      |
| `unmark`    | Unmarks a completed task  | `unmark 1`                                    |
| `find`      | Searches tasks by keyword | `find Math`                                   |
| `bye`       | Exits the program         | `bye`                                         |

## 12. Conclusion

Monkey is your personal task assistant that keeps your to-dos organized and easily manageable. Start using Monkey today and take control of your tasks effortlessly! 🐵🎉