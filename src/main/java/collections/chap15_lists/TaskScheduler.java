package collections.chap15_lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import collections.chap14_queue.StoppableTaskQueue;
import collections.task.PriorityTask;

/**
 * Description
 *
 *
 */
public class TaskScheduler {
		private List<StoppableTaskQueue> schedule;
		private final int FORWARD_PLANNING_DAYS = 365;

		public TaskScheduler() {
				List<StoppableTaskQueue> temp = new ArrayList<StoppableTaskQueue>();
				for (int i = 0; i < FORWARD_PLANNING_DAYS; i++) {
				    temp.add(new StoppableTaskQueue());
				}
				schedule = new CopyOnWriteArrayList<StoppableTaskQueue>(temp);
		}

		public PriorityTask getTaske() {
				for (StoppableTaskQueue daysTaskQueue : schedule) {
						PriorityTask topTask = daysTaskQueue.getTask();
						if (topTask != null) {
								return topTask;
						}
				}
				return null; // no outstanding tasks - at all?
		}

		// at midnight, remove and shut down the queue for day 0, assign its tasks
		// to the new day's queue at the planning horizon
		public void rollOver() throws InterruptedException{
				StoppableTaskQueue oldDay = schedule.remove(0);
				Collection<PriorityTask> remainingTasks = oldDay.shutDown();
				StoppableTaskQueue firstDay = schedule.get(0);
				for (PriorityTask task : remainingTasks) {
						firstDay.addTask(task);
				}
				StoppableTaskQueue lastDay = new StoppableTaskQueue();
				schedule.add(lastDay);
		}

		public void addTask(PriorityTask task, int day) {
				if (day < 0 || day >= FORWARD_PLANNING_DAYS) {
						throw new IllegalArgumentException("day out range");
				}
				StoppableTaskQueue daysTaskQueue = schedule.get(0);
				if (daysTaskQueue.addTask(task)) return;
				// StoppableTaskQueue.addTask returns false only when called on a queue that has been shut down, it will
				// also have been removed by now, so it's safe to try again.
				if (!schedule.get(0).addTask(task)) {
						throw new IllegalStateException("failed to add task " + task);
				}


		}




}
