package collections.chap13_sets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import collections.task.CodingTask;
import collections.task.PhoneTask;
import collections.task.Task;
import collections.task.TaskCreator;

/**
 * Description
 *
 *
 */
public class TaskClient {
		public static void main(String[] args) {
				try {
						TaskCreator taskCreator = TaskCreator.getInstance().addPhoneTasks().addMondayTasks();

						Set<Task> phoneAndMondayTasks = new TreeSet<>(taskCreator.getMondayTasks());
						phoneAndMondayTasks.addAll(taskCreator.getPhoneTasks());
						System.out.println(phoneAndMondayTasks.toString());

						assert phoneAndMondayTasks.toString().equals("[code logic, phone Mike, phone Paul]");

				} catch (Exception e) {
						e.printStackTrace();
				}
		}
}
