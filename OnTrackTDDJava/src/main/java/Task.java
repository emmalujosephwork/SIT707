import java.time.LocalDateTime;

public class Task {
    private String studentId;
    private String content;
    private LocalDateTime timestamp;

    public Task(String studentId, String content, LocalDateTime timestamp) {
        this.studentId = studentId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
