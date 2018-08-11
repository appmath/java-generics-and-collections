package collections.chap14_queue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Delayed;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Set;
import java.util.HashSet;

import collections.task.Task;
import collections.task.TaskCreator;


public class DelayedTask implements Delayed {

		public final static long MILLISECONDS_IN_DAY = 60 * 60 * 24 * 1000;
		private long endTime; // in milliseconds after January 1, 1970
		private Task task;


		public DelayedTask(Task t, int dayDelay) {
				this.endTime = System.currentTimeMillis() + dayDelay * MILLISECONDS_IN_DAY;
				this.task = t;
		}

		public long getDelay(TimeUnit unit) {
			long remainingTime = endTime - System.currentTimeMillis();
				return unit.convert(remainingTime, TimeUnit.MILLISECONDS);
		}

		public int compareTo(Delayed t) {
				long thisDelay = getDelay(TimeUnit.MILLISECONDS);
				long otherDelay = t.getDelay(TimeUnit.MILLISECONDS);
				return (thisDelay < otherDelay) ? -1 : (thisDelay > otherDelay) ? 1 : 0;
		}

		public Task getTask() {
				return task;
		}
}