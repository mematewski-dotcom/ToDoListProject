package zClassToDoList;

public interface Recurring {
	
	/**
	 * sets the recurrence pattern as a string 
	 * @param pattern as a string
	 */
	void setRecurrencePattern(String pattern);
	
	
	/**
	 * gets the recurrence pattern
	 * @return the pattern as a string
	 */
	String getRecurrencePattern();
	
	
	
}
