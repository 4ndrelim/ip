package duke.task;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Class for TaskList to store a collections of tasks.
 *
 * @author Andre Lin HuiKai
 * @version CS2103T AY22/23 Semester 2
 */
public class TaskList {
    private List<Task> tasks;

    /**
     * Overloaded constructor for the creation of a TaskList object.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor for the creation of a TaskList object.
     * @param tasks List of tasks to be included in TaskList after creation.
     */
    public TaskList(List<Task> tasks) {this.tasks = tasks; }

    /**
     * Gets the list of tasks.
     * @return List of tasks.
     */
    public List<Task> getTasks() { return this.tasks; }

    /**
     * Gets the number of tasks in the TaskList.
     * @return Integer representing number of tasks.
     */
    public int size() {
        return this.tasks.size();
    }

    /**
     * Adds a given task to the TaskList object.
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Deletes the task identified by its order in the TaskList.
     * @param taskNum The number corresponding to the task to be deleted.
     * @return The deleted task.
     */
    public Task delete(int taskNum) {
        return this.tasks.remove(taskNum-1);
    }

    /**
     * Toggles the task, identified by its order, as completed.
     * @param taskNum The number corresponding to the task to be marked as completed.
     * @return Information of the task in string representation.
     */
    public String toggleMark(int taskNum) {
        Task task = tasks.get(taskNum-1);
        task.markTask();
        return task.getStatusIcon();
    }

    /**
     * Toggles the task, identified by its order, as incomplete.
     * @param taskNum The number corresponding to the task to be marked as incomplete.
     * @return Information of the task in string representation.
     */
    public String toggleUnmark(int taskNum) {
        Task task = tasks.get(taskNum-1);
        task.unmarkTask();
        return task.getStatusIcon();
    }

    /**
     * Displays information about all the tasks tracked by the TaskList.
     * @return String with information across all tasks.
     */
    public String listTasks() {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < this.tasks.size(); i++) {
            Task curr = this.tasks.get(i);
            display.append((i+1) + ". " + curr.getStatusIcon());
            if (i < this.tasks.size()-1) {
                display.append("\n");
            }
        }
        return display.toString();
    }

    /**
     * Displays information of all the tasks that occur on this date.
     * @param date The date to check against.
     * @return String with information of all tasks on the specified date.
     */
    public String listAllOnDate(LocalDate date) {
        StringBuilder display = new StringBuilder();
        int count = 1;
        for (int i = 0; i < this.tasks.size(); i++) {
            Task curr = this.tasks.get(i);
            if (curr.fallsOnDate(date)) {
                display.append((count) + ". " + curr.getStatusIcon() + "\n");
                count++;
            }
        }
        return display.toString();
    }
}