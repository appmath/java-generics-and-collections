package collections.task;

/**
 * Description
 *
 *
 */
public final class PriorityTask implements Comparable<PriorityTask> {

		private final Task task;
		private final Priority priority;

		public PriorityTask(final Task task, final Priority priority) {
				this.task = task;
				this.priority = priority;
		}

		public Task getTask() {
				return task;
		}

		public Priority getPriority() {
				return priority;
		}

		@Override
		public int compareTo(PriorityTask pt) {
				int c = priority.compareTo(pt.priority);
				return c != 0 ? c : task.compareTo(pt.task);
		}

		@Override
		public boolean equals(Object o) {
				if (o instanceof PriorityTask) {
						final PriorityTask pt = (PriorityTask) o;
						return task.equals(pt.task) && priority.equals(pt.priority);
				} else return false;
		}

		@Override
		public int hashCode() {
				return task.hashCode();
		}

		@Override
		public String toString() {
				return task + ": " + priority;
		}
}
