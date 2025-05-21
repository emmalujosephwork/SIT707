package com.ontrack;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OnTrackFunctionsTest {

    @Test
    public void testSubmitTask() {
        String result = OnTrackFunctions.submitTask("S123", "T001", "My Assignment");
        assertTrue(result.contains("submitted"));
    }

    @Test
    public void testFeedbackStatus() {
        OnTrackFunctions.submitTask("S123", "T002", "Another Task");
        assertEquals("Pending Review", OnTrackFunctions.getFeedbackStatus("T002"));
    }

    @Test
    public void testSendMessageAndViewHistory() {
        OnTrackFunctions.sendMessage("T002", "S123", "Hello Tutor");
        List<OnTrackFunctions.Message> history = OnTrackFunctions.viewChatHistory("T002");
        assertFalse(history.isEmpty());
        assertEquals("S123", history.get(history.size() - 1).sender);
    }

    @Test
    public void testEmptyChatHistory() {
        assertTrue(OnTrackFunctions.viewChatHistory("T999").isEmpty());
    }

    @Test
    public void testInvalidTaskStatus() {
        assertEquals("Task not found.", OnTrackFunctions.getFeedbackStatus("InvalidID"));
    }
}
