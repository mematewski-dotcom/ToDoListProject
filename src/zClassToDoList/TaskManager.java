package zClassToDoList;


public class TaskManager {
	MyArrayList<Task> mal = new MyArrayList<>();
	
	/**
	 * adds a task to the arraylist
	 * @param T takes the task to be added
	 */
	public void addTask(Task T) {
		mal.add(T);
	}
	
	/**
	 * displays all the tasks in a menu like format
	 */
	public void displayAllTasks() {
	    if (mal.isEmpty()) {
	        System.out.println("No tasks to display.");
	        return;
	    }
	    for (int i = 0; i < mal.size(); i++) {
	        System.out.println((i + 1) + ". " + mal.get(i).toString());
	    }
	}
	
	/**
	 * checks if the arraylist is empty
	 * @return true if empty, false if not
	 */
	public boolean isEmpty() {
	    return mal.isEmpty();
	}
	
	/**
	 * removes a task from the arraylist
	 * @param index the index of what task is being removed
	 */
	public void remove(int index) {
		mal.remove(index);
	}
	
	/**
	 * overloaded method, removes a task from the arraylist
	 * @param task the task to be removed
	 */
	public void remove(Task task) {
	    mal.remove(task);
	}
	
	/**
	 * marks a task in the array list as complete
	 * @param index the index of the task to be marked
	 */
	public void markComplete(int index) {
	    mal.get(index).markComplete();
	}
	
	/**
	 * gets the size of the arraylist
	 * @return the size as an int
	 */
	public int size() {
		return mal.size();
	}
	
	/**
	 * gets a task at a specific index
	 * @param index to be found
	 * @return the task at the index
	 */
	public Task getTask(int index) {
	    return mal.get(index);
	}
	
	/**
	 * filters and displays tasks by completion status
	 * @param completed true for completed, false for incomplete
	 */
	public void filterByCompletion(boolean completed) {
	    boolean found = false;
	    for (int i = 0; i < mal.size(); i++) {
	        Task task = mal.get(i);
	        if (task.isCompleted() == completed) {
	            System.out.println(task.toString());
	            found = true;
	        }
	    }
	    if (!found) System.out.println("No tasks found.");
	}

	/**
	 * filters and displays tasks by type
	 * @param type the task type as a string ("Simple Task", "Priority Task", "Recurring Task")
	 */
	public void filterByType(String type) {
	    boolean found = false;
	    for (int i = 0; i < mal.size(); i++) {
	        Task task = mal.get(i);
	        if (task.getTaskType().equals(type)) {
	            System.out.println(task.toString());
	            found = true;
	        }
	    }
	    if (!found) System.out.println("No tasks found.");
	}

	/**
	 * filters and displays tasks by priority for priority tasks
	 * @param priority the priority as an int 1, 2, or 3 which are low medium high
	 */
	public void filterByPriority(int priority) {
	    boolean found = false;
	    for (int i = 0; i < mal.size(); i++) {
	        Task task = mal.get(i);
	        
	        //got help from AI on this line for casting
	        if (task instanceof PriorityTask && ((PriorityTask) task).getPriority() == priority) {	            System.out.println(task.toString());
	            found = true;
	        }
	    }
	    if (!found) System.out.println("No priority tasks found with that priority.");
	}
	
}
