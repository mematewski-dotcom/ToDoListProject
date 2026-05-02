package zClassToDoList;

import java.time.LocalDate;

public class SimpleTask extends Task  {

	/**
	 * instansiates the SimpleTask object. Sets the priority to 0 because it's not a priorityTask
	 * @param title as a string
	 * @param description as a string
	 * @param dueDate as a localdate
	 */
	public SimpleTask(String title, String description, LocalDate dueDate) {
		super(title, description, dueDate);
	}

	/**
	 * will get the task type
	 * @return the task type as a string
	 */
	@Override
	String getTaskType() {
		return "Simple Task";
	}

	/**
	 * gets the details based off the special task type as a String
	 * @return the details as a String
	 */
	@Override
	String getDetails() {
		return "No details to display.";
	}

}
