package collections.bestpractice;

import collections.task.CodingTask;
import collections.task.PhoneTask;
import collections.task.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;


/**
 * Description
 *
 *
 */
public class SafeRemoval {
		public static void main(String[] args) {
				try {
						PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");

						CodingTask databaseCode = new CodingTask("db");
						CodingTask interfaceCode = new CodingTask("gui");


						Collection<Task> tuesdayTasks = new ArrayList<Task>();


						resetCollection(paulPhone, databaseCode, interfaceCode, tuesdayTasks);
						unsafeRemoval1(tuesdayTasks);

						resetCollection(paulPhone, databaseCode, interfaceCode, tuesdayTasks);
						unsafeRemoval2(tuesdayTasks);

						resetCollection(paulPhone, databaseCode, interfaceCode, tuesdayTasks);
						safeRemoval(tuesdayTasks);

				} catch (Exception e) {
						e.printStackTrace();
				}
		}

		private static void resetCollection(PhoneTask paulPhone, CodingTask databaseCode, CodingTask interfaceCode,
																				Collection<Task> tuesdayTasks
																			 ) {
				tuesdayTasks.clear();
				Collections.addAll(tuesdayTasks, databaseCode, interfaceCode, paulPhone);
		}

		// throws ConcurrentModificationException
		private static void unsafeRemoval2(Collection<Task> tuesdayTasks) {
				try {
						for (Iterator<Task> it = tuesdayTasks.iterator(); it.hasNext(); ) {
								Task t = it.next();
								if (t instanceof PhoneTask) {
										tuesdayTasks.remove(t);
								}
						}
				} catch (Exception e) {
						System.out.println("unsafeRemoval2 bombed: " + e);
				}
		}

		// throws ConcurrentModificationException
		private static void unsafeRemoval1(Collection<Task> tuesdayTasks) {
				try {
						for (Task t : tuesdayTasks) {
								if (t instanceof PhoneTask) {
										tuesdayTasks.remove(t);
								}
						}
				} catch (Exception e) {
						System.out.println("unsafeRemoval1 bombed: " + e);
				}
		}

		private static void safeRemoval(Collection<Task> tuesdayTasks) {
				for (Iterator<Task> it = tuesdayTasks.iterator(); it.hasNext(); ) {
						Task t = it.next();
						if (t instanceof PhoneTask) {
								it.remove();
						}
				}
		}
}
