package zClassToDoList;

import java.time.LocalDate;

public class RecurringTask extends Task implements Recurring{
	private String recurrencePattern = "";
	
	
	/**
	 * instansiates the SimpleTask object. Sets the priority to 0 because it's not a priorityTask
	 * @param title as a string
	 * @param description as a string
	 * @param dueDate as a localdate
	 */
	public RecurringTask(String title, String description, LocalDate dueDate, String pattern) {
		super(title, description, dueDate);
		this.recurrencePattern = pattern;
	}

	/**
	 * get the task type
	 * @return the task type as a string
	 */
	@Override
	String getTaskType() {
		return "Recurring Task";
	}

	/**
	 * gets the details based off the special task type as a String
	 * @return the details as a String
	 */
	@Override
	String getDetails() {
		return "Reoccurence Pattern: " + recurrencePattern;
	}

	/**
	 * sets the recurrence pattern as a string 
	 * @param pattern as a string
	 */
	@Override
	public void setRecurrencePattern(String pattern) {
		recurrencePattern = pattern;
	}

	/**
	 * gets the recurrence pattern
	 * @return the pattern as a string
	 */
	@Override
	public String getRecurrencePattern() {
		return recurrencePattern;
	}

}
