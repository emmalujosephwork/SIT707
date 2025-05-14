import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testSubmitTaskStoresTaskCorrectly() {
        TaskService service = new TaskService();
        Task task = service.submitTask("s101", "Assignment 1 content");

        assertEquals("s101", task.getStudentId());
        assertNotNull(task.getTimestamp());
        assertEquals("Assignment 1 content", task.getContent());
    }

    @Test
    public void testGetTasksByStudentIdReturnsCorrectTasks() {
        TaskService service = new TaskService();
        service.submitTask("s101", "Assignment 1");
        service.submitTask("s102", "Assignment 2");
        service.submitTask("s101", "Assignment 3");

        List<Task> s101Tasks = service.getTasksByStudentId("s101");

        assertEquals(2, s101Tasks.size());
        for (Task task : s101Tasks) {
            assertEquals("s101", task.getStudentId());
        }
    }
}
