    package monkey.task;

    public abstract class Task {
        protected String description;
        protected boolean isDone;
        protected String taskType;

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
