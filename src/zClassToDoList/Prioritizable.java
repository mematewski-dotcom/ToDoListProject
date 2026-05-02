package zClassToDoList;

public interface Prioritizable {

	/**
	 * creates the ablity to have a dynamic priority
	 * @param priority an int, 1 2 or 3 (low, med, high)
	 */
	void setPriority(int priority);
	
	//the spec requires getPriority in both the abstract class and the interface and 
	//although it isn't the cleanest way, I didn't want to lose points by not including it
	/**
	 * returns the priority
	 * @return priority as an int
	 */
	int getPriority();
	
	
	
}
