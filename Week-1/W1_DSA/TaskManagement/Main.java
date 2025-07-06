package TaskManagement;

class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        head = null;
    }

    // Add task to end of list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("Task added.");
    }

    // Search task by ID
    public Task searchTask(int taskId) {
        Node curr = head;
        while (curr != null) {
            if (curr.task.taskId == taskId) {
                return curr.task;
            }
            curr = curr.next;
        }
        return null;
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.println(curr.task);
            curr = curr.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Node curr = head;
        while (curr.next != null && curr.next.task.taskId != taskId) {
            curr = curr.next;
        }

        if (curr.next == null) {
            System.out.println("Task not found.");
        } else {
            curr.next = curr.next.next;
            System.out.println("Task deleted.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design database", "Pending"));
        taskList.addTask(new Task(2, "Implement login", "Pending"));
        taskList.addTask(new Task(3, "Test APIs", "Completed"));

        System.out.println("\nAll Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task ID 2:");
        Task t = taskList.searchTask(2);
        System.out.println(t != null ? t : "Task not found.");

        System.out.println("\nDeleting Task ID 2...");
        taskList.deleteTask(2);

        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}

