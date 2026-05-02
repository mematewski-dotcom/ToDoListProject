package zClassToDoList;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
	TaskManager taskManager = new TaskManager();
	Scanner scanner = new Scanner(System.in);
	UndoFunction undo = new UndoFunction();
	QueueFunction queueFunction = new QueueFunction();

	public void homeMenu() {
		String input = "";

		while (!input.equals("10")) {
		    System.out.println("\n=== To-Do List Menu ===");
		    System.out.println("1. Add Task");
		    System.out.println("2. View All Tasks");
		    System.out.println("3. Complete Task");
		    System.out.println("4. Remove Task");
		    System.out.println("5. Undo Last Action");
		    System.out.println("6. Load Today's Tasks");
		    System.out.println("7. View Task Queue");
		    System.out.println("8. Process Next Task");
		    System.out.println("9. Filter Tasks");
		    System.out.println("10. Exit");
		    System.out.print("Enter your choice: ");

		    input = scanner.nextLine();

		    switch (input) {
		        case "1": addTask();
		            break;
		        case "2": viewAllTasks();
		            break;
		        case "3": completeTask();
		            break;
		        case "4": removeTask();
		            break;
		        case "5": undoLastAction();
		            break;
		        case "6": loadTodaysTasks();
		            break;
		        case "7": viewTaskQueue();
		            break;
		        case "8": processNextTask();
		            break;
		        case "9": filterTasks();
		            break;
		        case "10":
		            System.out.println("Goodbye!");
		            break;
		        default:
		            System.out.println("Invalid choice. Please try again.");
		    }
		}
	    scanner.close();
	} //end home menu
	
	
	/**
	 * 1. Adds a Task
	 */
	private void addTask() {
		System.out.print("Enter task title: ");
		String title = scanner.nextLine();

		System.out.print("Enter task description: ");
		String description = scanner.nextLine();

		System.out.print("Enter due date (YYYY-MM-DD): ");
		LocalDate dueDate = LocalDate.parse(scanner.nextLine());

		System.out.println("What type of task?");
		System.out.println("1. Simple");
		System.out.println("2. Priority");
		System.out.println("3. Recurring");
		String type = scanner.nextLine();
		
		Task task = null;
		switch (type) {
		    case "1":
		        task = new SimpleTask(title, description, dueDate);
		        break;
		    case "2":
		        System.out.print("Enter priority (1=low, 2=medium, 3=high): ");
		        int priority = Integer.parseInt(scanner.nextLine());
		        task = new PriorityTask(title, description, dueDate, priority);
		        break;
		    case "3":
		        System.out.print("Enter recurrence pattern (e.g. daily, weekly): ");
		        String pattern = scanner.nextLine();
		        task = new RecurringTask(title, description, dueDate, pattern);
		        break;
		    default:
		        System.out.println("Invalid task type.");
		}

	if (task != null) taskManager.addTask(task);
	
	}
	
	/**
	 * 2. Displays all the tasks
	 */
	private void viewAllTasks() {
	    taskManager.displayAllTasks();
	}
	
	/**
	 * 3. Marks a task as complete
	 */
	private void completeTask() {
	    if (taskManager.isEmpty()) {
	        System.out.println("No tasks to complete.");
	        return;
	    }
	    taskManager.displayAllTasks();
	    System.out.print("Enter the number of the task to mark complete: ");
	    int index = Integer.parseInt(scanner.nextLine()) - 1;
	    taskManager.markComplete(index);
	    System.out.println("Task marked as complete!");
	}
	
	/**
	 * 4. Removes a task from the list
	 */
	private void removeTask() {
	    if (taskManager.isEmpty()) {
	        System.out.println("No tasks to remove.");
	        return;
	    }
	    taskManager.displayAllTasks();
	    System.out.print("Enter the number of the task to remove: ");
	    String input = scanner.nextLine();
	    int index = Integer.parseInt(input) - 1;
	    taskManager.remove(index);
	    System.out.println("Task removed.");
	}
	
	
	/**
	 * 5. calls the undo function
	 */
	private void undoLastAction() {
	    undo.undo(taskManager);
	}
	
	/**
	 * 6. populates the tasks marked as today on LocalDate
	 */
	private void loadTodaysTasks() {
	    queueFunction.loadTodaysTasks(taskManager);
	}

	/**
	 * 7. displays the queue
	 */
	private void viewTaskQueue() {
	    queueFunction.viewQueue();
	}

	/**
	 * 8. lets you view the task and optionally mark it as complete
	 */
	private void processNextTask() {
	    queueFunction.processNextTask(scanner);
	}
	
	/**
	 * 9. the menu to choose filter options and calls filter methods in Tsak Manager 
	 */
	private void filterTasks() {
	    System.out.println("\n=== Filter Tasks ===");
	    System.out.println("1. Filter by completion status");
	    System.out.println("2. Filter by task type");
	    System.out.println("3. Filter by priority");
	    System.out.print("Enter your choice: ");
	    
	    String input = scanner.nextLine();
	    
	    switch (input) {
	        case "1":
	            System.out.println("1. Completed  2. Incomplete");
	            String statusInput = scanner.nextLine();
	            boolean completed = statusInput.equals("1");
	            taskManager.filterByCompletion(completed);
	            break;
	        case "2":
	            System.out.println("1. Simple  2. Priority  3. Recurring");
	            String typeInput = scanner.nextLine();
	            switch (typeInput) {
	                case "1": taskManager.filterByType("Simple Task"); break;
	                case "2": taskManager.filterByType("Priority Task"); break;
	                case "3": taskManager.filterByType("Recurring Task"); break;
	                default: System.out.println("Invalid choice.");
	            }
	            break;
	        case "3":
	            System.out.print("Enter priority to filter by (1=low, 2=medium, 3=high): ");
	            int priority = Integer.parseInt(scanner.nextLine());
	            taskManager.filterByPriority(priority);
	            break;
	        default:
	            System.out.println("Invalid choice.");
	    }
	}
	
	
	
	
	
}
