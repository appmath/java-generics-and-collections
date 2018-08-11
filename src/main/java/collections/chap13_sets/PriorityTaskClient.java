package collections.chap13_sets;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import collections.task.EmptyTask;
import collections.task.Priority;
import collections.task.PriorityTask;
import collections.task.TaskCreator;

import static collections.task.Priority.*;

/**
 * Description
 *
 *
 */
public class PriorityTaskClient {
		public static void main(String[] args) {
				try {

						// HERE IS SOMETHING TO REMEMBER: HIGH=0, MEDIUM=1, LOW=2

						NavigableSet<PriorityTask> priorityTasks = new TreeSet<>();
						TaskCreator tc = TaskCreator.getInstance().addPhoneTasks().addCodingTasks();

						// Remember that TreeSet is used for preserve the natural ordering
						priorityTasks.add(new PriorityTask(tc.getMikePhone(), MEDIUM));
						priorityTasks.add(new PriorityTask(tc.getPaulPhone(), HIGH));
						final PriorityTask dbTask = new PriorityTask(tc.getDatabaseCode(), MEDIUM);
						priorityTasks.add(dbTask);
						priorityTasks.add(new PriorityTask(tc.getInterfaceCode(), LOW));

						System.out.println(priorityTasks.toString());
						
						assert(priorityTasks.toString()).equals("[phone Paul: HIGH, code db: MEDIUM, " +
																								     "phone Mike: MEDIUM, code gui: LOW]");

						PriorityTask firstLowPriorityTask = new PriorityTask(new EmptyTask(), Priority.LOW);
						SortedSet<PriorityTask> highAndMediumPriorityTasks = priorityTasks.headSet(firstLowPriorityTask);
						System.out.println("highAndMediumPriorityTasks: " + highAndMediumPriorityTasks);

						assert highAndMediumPriorityTasks.toString().equals( "[phone Paul: HIGH, code db: MEDIUM, " +
																																 "phone Mike: MEDIUM]");

						final SortedSet<PriorityTask> lessThanDBmedium = priorityTasks.headSet(dbTask);
						System.out.println("lessThanDBmedium: " + lessThanDBmedium);


						PriorityTask nextTask = priorityTasks.pollFirst();
						assert nextTask.toString().equals("phone Paul: HIGH");

				} catch (Exception e) {
						e.printStackTrace();
				}
		}
}
