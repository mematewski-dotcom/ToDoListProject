package zClassToDoList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueFunction {
    Queue<Task> queue = new LinkedList<>();
    
    /**
     * clears the queue and reloads all recurring tasks from the task manager
     * @param taskManager the task manager to pull recurring tasks from
     */
    public void loadTodaysTasks(TaskManager taskManager) {
        queue.clear();
        for (int i = 0; i < taskManager.size(); i++) {
            Task task = taskManager.getTask(i);
            if (task instanceof RecurringTask) {
                queue.add(task);
            }
        }
        System.out.println("Loaded " + queue.size() + " recurring tasks into queue.");
    }
    
    /**
     * displays all tasks currently in the queue in order
     */
    public void viewQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int i = 1;
        for (Task task : queue) {
            System.out.println(i++ + ". " + task.toString());
        }
    }
    
    /**
     * removes and displays the next task in the queue, optionally marks it complete
     * @param scanner to read user input
     */
    public void processNextTask(Scanner scanner) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Task task = queue.poll();
        System.out.println("Processing: " + task.toString());
        System.out.print("Mark as complete? (y/n): ");
        if (scanner.nextLine().equals("y")) {
            task.markComplete();
            System.out.println("Task marked complete!");
        }
    }
    
    /**
     * checks if the queue is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}