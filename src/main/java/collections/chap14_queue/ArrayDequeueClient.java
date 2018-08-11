package collections.chap14_queue;

import java.util.ArrayDeque;
import java.util.Queue;

import collections.task.PhoneTask;
import collections.task.Task;
import collections.task.TaskCreator;
import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * Description
 *
 *
 */
public class ArrayDequeueClient {
		public static void main(String[] args) {
				try {
						TaskCreator tc = TaskCreator.getInstance().addPhoneTasks();
						Queue<Task> taskQueue = new ArrayDeque<>();
						taskQueue.offer(tc.getMikePhone());
						taskQueue.offer(tc.getPaulPhone());

						final Task task = taskQueue.poll();
						if (task != null) {
								System.out.println("task: " + task);
						}
						Task nextTask = taskQueue.peek();
						if (nextTask instanceof PhoneTask) {
								System.out.println("taskQueue.remove(): " + taskQueue.remove());
                // process nextTask
						}

				} catch (Exception e) {
						e.printStackTrace();
				}
		}
}
