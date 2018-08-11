package collections.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Description
 *
 *
 */
public class TaskCreator {
		PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
		PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");

		CodingTask databaseCode = new CodingTask("db");
		CodingTask interfaceCode = new CodingTask("gui");
		CodingTask logicCode = new CodingTask("logic");

		Collection<PhoneTask> phoneTasks = new ArrayList<PhoneTask>();
		Collection<CodingTask> codingTasks = new ArrayList<CodingTask>();
		Collection<Task> mondayTasks = new ArrayList<Task>();
		Collection<Task> tuesdayTasks = new ArrayList<Task>();

		private TaskCreator() { }

		public static TaskCreator getInstance(){
		     return SingletonHolder.INSTANCE;
		}
		public TaskCreator addPhoneTasks() {
				Collections.addAll(phoneTasks, mikePhone, paulPhone);
				return this;
		}

		public TaskCreator addCodingTasks() {
				Collections.addAll(codingTasks, databaseCode, interfaceCode, logicCode);
				return this;
		}

		public TaskCreator addMondayTasks() {
				Collections.addAll(mondayTasks, logicCode, mikePhone);
				return this;
		}

		public TaskCreator addTuesdayTasks() {
				Collections.addAll(tuesdayTasks, databaseCode, interfaceCode, paulPhone);
				return this;
		}

		public TaskCreator addAll() {
				addPhoneTasks();
		    addCodingTasks();
				addMondayTasks();
				addTuesdayTasks();
				return this;
		}


		public PhoneTask getMikePhone() { return mikePhone; }
		public PhoneTask getPaulPhone() { return paulPhone; }
		public CodingTask getDatabaseCode() { return databaseCode; }
		public CodingTask getInterfaceCode() { return interfaceCode; }
		public CodingTask getLogicCode() { return logicCode; }

		public Collection<PhoneTask> getPhoneTasks() { return phoneTasks; }
		public Collection<CodingTask> getCodingTasks() {
				return codingTasks;
		}
		public Collection<Task> getMondayTasks() {
				return mondayTasks;
		}
		public Collection<Task> getTuesdayTasks() {
				return tuesdayTasks;
		}

	 private static class SingletonHolder {
			 private static final TaskCreator INSTANCE = new TaskCreator();
	 }
}
