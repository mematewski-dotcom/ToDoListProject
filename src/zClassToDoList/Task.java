package zClassToDoList;

import java.time.LocalDate;

public abstract class Task {
	private String title;
	private String description;
	private boolean completed;
	private LocalDate dueDate;
//	protected int priority; - I removed this despite the spec because it only has a meaningful
//difference in the priority task
	
	/**
	 * The constructor method for any task. completed is automatically set to false and can 
	 * be marked as completed separately. 
	 * @param title title of the task as a String
	 * @param description a description for the task as a String
	 * @param dueDate the dueDate as a LocalDate (ex: 2024, 5, 26)
	 * @param priority as an int
	 */
	public Task (String title, String description, LocalDate dueDate) {
		completed = false;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}
	
	/**
	 * marks a task as completed
	 */
	public void markComplete() {
		completed = true;
	}
	
	/**
	 * used to undo the complete
	 */
	public void undoComplete() {
	    completed = false;
	}
	
	/**
	 * turns the task into a String to be printed
	 */
	@Override
	public String toString() {
		String str = title;
		
		str += " - Due Date: ";
		str += dueDate.toString();
		
		return str;
	}
	
	//=======================ABSTRACT METHODS===========================
	/**
	 * will get the task type
	 * @return the task type as a string
	 */
	abstract String getTaskType();
	
	/**
	 * gets the details based off the special task type as a String
	 * @return the details as a String
	 */
	abstract String getDetails();
	
	//=======================GETTERS====================================
	/**
	 * gets the title
	 * @return title as a String
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * gets the description
	 * @return returns the description as a String
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * gets the completion
	 * @return true if it's completed, false otherwise
	 */
	public boolean isCompleted() {
		return completed;
	}
	
	/**
	 * gets the due date
	 * @return the duedate as a LocalDate
	 */
	public LocalDate getDueDate() {
		return dueDate;
	}
	
}
