import java.time.LocalDateTime;

public class TaskService {

    public Task submitTask(String studentId, String content) {
        return new Task(studentId, content, LocalDateTime.now());
    }
}
