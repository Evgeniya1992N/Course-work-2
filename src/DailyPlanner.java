import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
public class DailyPlanner {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Пример добавления задач
        taskManager.addTask(new Task("Погулять с собакой", "Прогулка в парке", true, RepeatType.DAILY));
        taskManager.addTask(new Task("Подготовить отчет", "Подготовить отчет по проекту", false, RepeatType.WEEKLY));

        // Пример получения списка задач на завтра
        List<Task> tasksForTomorrow = taskManager.getTasksForTomorrow();
        if (tasksForTomorrow.isEmpty()) {
            System.out.println("На завтра задач нет.");
        } else {
            System.out.println("Список задач на завтра:");
            for (Task task : tasksForTomorrow) {
                System.out.println("- " + task.getTitle());
            }
        }
    }
}