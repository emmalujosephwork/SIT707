package com.ontrack;

import java.util.*;

public class OnTrackFunctions {
    private static Map<String, Task> tasks = new HashMap<>();
    private static Map<String, List<Message>> chats = new HashMap<>();

    public static String submitTask(String studentId, String taskId, String content) {
        tasks.put(taskId, new Task(studentId, content, "Pending Review"));
        return "Task " + taskId + " submitted by " + studentId;
    }

    public static String getFeedbackStatus(String taskId) {
        Task task = tasks.get(taskId);
        return (task != null) ? task.status : "Task not found.";
    }

    public static String sendMessage(String taskId, String sender, String message) {
        chats.putIfAbsent(taskId, new ArrayList<>());
        chats.get(taskId).add(new Message(sender, message));
        return "Message sent.";
    }

    public static List<Message> viewChatHistory(String taskId) {
        return chats.getOrDefault(taskId, new ArrayList<>());
    }

    static class Task {
        String studentId, content, status;
        Task(String studentId, String content, String status) {
            this.studentId = studentId;
            this.content = content;
            this.status = status;
        }
    }

    public static class Message {
        public String sender, content;
        public Message(String sender, String content) {
            this.sender = sender;
            this.content = content;
        }

        public String toString() {
            return sender + ": " + content;
        }
    }
}
