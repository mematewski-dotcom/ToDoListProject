package zClassToDoList;

import java.time.LocalDate;

public class PriorityTask extends Task implements Prioritizable{
	int priority;
	/**
	 * instansiates the SimpleTask object. 
	 * @param title as a string
	 * @param description as a string
	 * @param dueDate as a localdate
	 */
	public PriorityTask(String title, String description, LocalDate dueDate, int priority) {
		super(title, description, dueDate);
		this.priority = priority;
	}

	/**
	 * get the task type
	 * @return the task type as a string
	 */
	@Override
	String getTaskType() {
		return "Priority Task";
	}

	/**
	 * gets the details based off the special task type as a String
	 * @return the details as a String
	 */
	@Override
	String getDetails() {
		String str = "Priority: ";
		
		switch (priority) {
		case (1): 
			str += "low";
			break;
		case (2): 
			str += "medium";
			break;
		case (3): 
			str += "high";
			break;
		default:
			str += "no priority set";  
	}
		return str;
	}

	/**
	 * creates the ablity to have a dynamic priority
	 * @param priority an int, 1 2 or 3 (low, med, high)
	 */
	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * returns the priority
	 * @return priority as an int
	 */
	@Override
	public int getPriority() {
		return priority;
	}
}
