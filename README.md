# ToDoListProject
To-Do List System
COS 161 - Algorithms in Programming

HOW TO RUN:
Run Main.java to start the program. Use the numbered menu to navigate.

FEATURES:
- Add simple, priority, and recurring tasks
- View, complete, and remove tasks
- Undo the last action using a stack
- Load recurring tasks into a queue and process them
- Filter tasks by completion status, type, or priority

DESIGN CHOICES:
- Priority field was moved out of the abstract Task class and kept only 
  in PriorityTask, as it is only meaningful for that task type.
- UndoFunction uses a Stack of Action objects (nested class) to track 
  add, remove, and complete actions.
- MyArrayList is a custom generic resizable array implementation.
