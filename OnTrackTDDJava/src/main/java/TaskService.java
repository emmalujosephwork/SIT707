import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private List<Task> taskList = new ArrayList<>();

    public Task submitTask(String studentId, String content) {
        Task task = new Task(studentId, content, LocalDateTime.now());
        taskList.add(task);
        return task;
    }

    public List<Task> getTasksByStudentId(String studentId) {
        List<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getStudentId().equals(studentId)) {
                result.add(task);
            }
        }
        return result;
    }
}
