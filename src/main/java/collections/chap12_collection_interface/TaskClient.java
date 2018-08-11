package collections.chap12_collection_interface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import collections.task.TaskCreator;

/**
 * Description
 *
 *
 */
public class TaskClient {
		public static void main(String[] args) {
				try {
						TaskCreator taskCreator = TaskCreator.getInstance().addPhoneTasks().addCodingTasks();

						assert taskCreator.getPhoneTasks().toString().equals("[phone Mike, phone Paul]");
						assert taskCreator.getCodingTasks().toString().equals("[code db, code gui, code logic]");
						assert taskCreator.getMondayTasks().toString().equals("[code logic, phone Mike]");
						assert taskCreator.getTuesdayTasks().toString().equals("[code db, code gui, phone Paul]");


				} catch (Exception e) {
						e.printStackTrace();
				}
		}
}
