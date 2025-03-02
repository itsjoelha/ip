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

        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }

        public void markDone() {
            isDone = true;
        }

        public void unmarkDone() {
            isDone = false;
        }

        @Override
        public String toString() {
            return "["  + taskType.toUpperCase().charAt(0) + "]" + "[" + getStatusIcon() + "] " + description;
        }

        public abstract String toFileString();
    }
