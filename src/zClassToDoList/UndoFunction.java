package zClassToDoList;

import java.util.Stack;

public class UndoFunction {
	Stack<Action> stack = new Stack<>();
	
	/**
	 * saves that a task was added
	 * @param task the task that was created
	 */
    public void recordAdd(Task task) {
        stack.push(new Action("add", task));
    }

	/**
	 * saves that a task was removed
	 * @param task
	 */
    public void recordRemove(Task task) {
        stack.push(new Action("remove", task));
    }

    /**
     * saves that a task was marked as complete
     * @param task the task that was marked as complete
     */
    public void recordComplete(Task task) {
        stack.push(new Action("complete", task));
    }
	
    /**
     * undoes the last action in the taskManager
     * @param taskManager takes the taskmanager that has the MyArrayList of tasks to be acted on
     */
    public void undo(TaskManager taskManager) {
        if (stack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        Action action = stack.pop();
        
        switch (action.type) {
            case "add":
                taskManager.remove(action.task);
                System.out.println("Undid: add task");
                break;
            case "remove":
                taskManager.addTask(action.task);
                System.out.println("Undid: remove task");
                break;
            case "complete":
                action.task.undoComplete();
                System.out.println("Undid: mark complete");
                break;
        }
    }
	
	
	/**
	 * Acts like a node, keeps track of the type action taken and on the task it was acted on
	 */
	private static class Action {
	    String type;
	    Task task;
	    
	    Action(String type, Task task) {
	        this.type = type;
	        this.task = task;
	    }
	}
	
	
}
