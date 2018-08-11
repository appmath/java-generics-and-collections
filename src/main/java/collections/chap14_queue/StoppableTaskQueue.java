package collections.chap14_queue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

import collections.task.PriorityTask;

/**
 * Description
 *
 *
 */
public class StoppableTaskQueue {
		private final int MAXIMUM_PENDING_OFFERS = Integer.MAX_VALUE;
		private final BlockingQueue<PriorityTask> taskQueue = new PriorityBlockingQueue<>();
		private boolean isStopped;
		private Semaphore semaphore = new Semaphore(MAXIMUM_PENDING_OFFERS);

		// return true if the task was successfully placed on the queue, false if the queue was shut down.
		public boolean addTask(final PriorityTask task) {
				synchronized (this) {
						if (isStopped) return false;
						if (!semaphore.tryAcquire()) throw new Error("Too many threads");
				}

				try {
						return taskQueue.offer(task);
				} finally {
      		semaphore.release();
				}
		}

		// return the head task from the queue, or null if no task is available
		public PriorityTask getTask() {
				return taskQueue.poll();
		}

		public Collection<PriorityTask> shutDown() {
				synchronized (this){ isStopped = true;}
				semaphore.acquireUninterruptibly(MAXIMUM_PENDING_OFFERS);
				final Set<PriorityTask> returnCollection = new HashSet<>();
				taskQueue.drainTo(returnCollection);
			  return returnCollection;
		}



}
