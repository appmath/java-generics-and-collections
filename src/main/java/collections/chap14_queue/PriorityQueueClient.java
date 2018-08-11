package collections.chap14_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import collections.task.Priority;
import collections.task.PriorityTask;
import collections.task.TaskCreator;

import static collections.task.Priority.LOW;
import static collections.task.Priority.MEDIUM;

/**
 * Description
 *
 *
 */
public class PriorityQueueClient {

		private static final int INITIAL_CAPACITY = 10;

		public static Comparator<PriorityTask> createPriorityComp(){
		     return new Comparator<PriorityTask>() {
						 @Override
						 public int compare(PriorityTask o1, PriorityTask o2) {
								 return o1.getPriority().compareTo(o2.getPriority());
						 }
				 };
		}
		public static void main(String[] args) {
				try {

						TaskCreator tc = TaskCreator.getInstance().addPhoneTasks();
						Queue<PriorityTask> pq = new PriorityQueue<>(INITIAL_CAPACITY, createPriorityComp());
						pq.add(new PriorityTask(tc.getMikePhone(), Priority.MEDIUM));
						pq.add(new PriorityTask(tc.getPaulPhone(), Priority.HIGH));
						pq.add(new PriorityTask(tc.getInterfaceCode(), LOW));
						pq.add(new PriorityTask(tc.getDatabaseCode(), MEDIUM));

						for (int i = 0; i < 4; i++) {
								System.out.println("pq.poll(): " + pq.poll());
						}

				} catch (Exception e) {
						e.printStackTrace();
				}
		}

}
