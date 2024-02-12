import java.time.LocalDateTime;

enum RepeatType {
    ONCE,
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY
}
public class Task {
    private static int idCounter = 1;

    private int id;
    private String title;
    private String description;
    private boolean personal;
    private RepeatType repeatType;
    private LocalDateTime createdAt;


    public Task(String title, String description, boolean personal, RepeatType repeatType) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.personal = personal;
        this.repeatType = repeatType;
        this.createdAt = LocalDateTime.now();

    }
    // Геттеры
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPersonal() {
        return personal;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Метод для получения следующей даты и времени выполнения
    public LocalDateTime getNextExecutionTime() {
        LocalDateTime now = LocalDateTime.now();
        switch (repeatType) {
            case ONCE:
                return null; // Однократная задача, нет следующей даты
            case DAILY:
                return createdAt.plusDays(1);
            case WEEKLY:
                return createdAt.plusWeeks(1);
            case MONTHLY:
                return createdAt.plusMonths(1);
            case YEARLY:
                return createdAt.plusYears(1);
            default:
                return null;
        }
    }
}

