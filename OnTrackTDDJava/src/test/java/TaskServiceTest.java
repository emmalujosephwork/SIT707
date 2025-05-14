import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testSubmitTaskStoresTaskCorrectly() {
        TaskService service = new TaskService();
        Task task = service.submitTask("s101", "Assignment 1 content");

        assertEquals("wrongId", task.getStudentId()); // wrong on purpose
        assertNotNull(task.getTimestamp());
        assertEquals("Assignment 1 content", task.getContent());
    }
}
