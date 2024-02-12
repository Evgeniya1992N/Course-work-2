import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }
    public List<Task> getTasksForTomorrow() {
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        List<Task> tasksForTomorrow = new ArrayList<>();
        for (Task task : tasks) {
            LocalDateTime nextExecutionTime = task.getNextExecutionTime();
            if (nextExecutionTime != null && nextExecutionTime.toLocalDate().equals(tomorrow.toLocalDate())) {
                tasksForTomorrow.add(task);
            }
        }
        return tasksForTomorrow;
    }



}
