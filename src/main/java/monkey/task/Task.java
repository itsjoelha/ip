    package monkey.task;

    /**
     * The Task class represents a task with a description, completion status, and
     * a task type.
     */
    public abstract class Task {
        /** The description of the task. */
        protected String description;

        /** Indicates whether the task is completed. */
        protected boolean isDone;

        /** The type of task. */
        protected String taskType;

        /**
         * Creates a Task with the given description and task type.
         * By default, the task is not completed.
         * @param description The description of the task.
         * @param taskType The type of task.
         */
        public Task(String description, String taskType) {
            this.description = description;
            this.isDone = false;
            this.taskType = taskType;
        }

        /**
         * Returns the status icon of the task.
         * @return "X" if the task is completed, otherwise a space " ".
         */
        public String getStatusIcon() {
            return (isDone ? "X" : " ");
        }

        /**
         * Marks the task as completed.
         */
        public void markDone() {
            isDone = true;
        }

        /**
         * Marks the task as not completed.
         */
        public void unmarkDone() {
            isDone = false;
        }

        /**
         * Returns a string representation of the task, including its type,
         * status, and description.
         * @return A formatted string representing the task.
         */
        @Override
        public String toString() {
            return "["  + taskType.toUpperCase().charAt(0) + "]" + "[" + getStatusIcon() + "] " + description;
        }

        /**
         * Returns a formatted string representation of the task for file storage.
         * @return A string representation of the task for saving to a file.
         */
        public abstract String toFileString();
    }
