package com.aditya.DesignPattern.lld.taskManagementSystem;

import java.util.Date;
import java.util.List;

public class TaskManagementService {

    private static TaskManagementService instance;

    private UserService userService;
    private TaskService taskService;
    private TaskHistoryService taskHistoryService;

    private TaskManagementService() {
        this.userService = new UserService();
        this.taskHistoryService = new TaskHistoryService();
        this.taskService = new TaskService();
    }

    public synchronized static TaskManagementService getInstance() {
        if (instance == null) {
            instance = new TaskManagementService();
        }

        return instance;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    public Task getTaskById(String taskId) {
        return taskService.getTaskById(taskId);
    }

    public List<Task> getAllTaskByPriority(int priority) {
        return taskService.getAllTaskByPriority(priority);
    }

    public List<Task> getAllTaskByAssignedUser(String assignedUserId) {
        return taskService.getAllTaskByAssignedUser(assignedUserId);
    }

    public List<Task> getAllTaskByDueDate(Date dueDate) {
        return taskService.getAllTaskByDueDate(dueDate);
    }

    public synchronized void removeTask(String taskId) {
        taskService.removeTask(taskId);
    }

    public synchronized void updateTaskStatus(String taskId, TaskStatus status) {
        Task task = taskService.updateTaskStatus(taskId, status);

        TaskHistory taskHistory = new TaskHistory(
                task.getTaskId(), task.getAssignedUserId(), "Status Updated :" + status.name());
        taskHistoryService.addTaskHistory(taskHistory);
    }

    public synchronized void updateAssignedUser(String taskId, String assignedUserId) {
        taskService.updateAssignedUser(taskId, assignedUserId);

        TaskHistory taskHistory = new TaskHistory(taskId, assignedUserId, "User Updated:" + assignedUserId);
        taskHistoryService.addTaskHistory(taskHistory);
    }

    public List<TaskHistory> getHistoryForTask(String taskId) {
        return taskHistoryService.getHistoryForTask(taskId);
    }

    public synchronized Task createTask(
            String title, String description, Date dueDate, int priority, String assignedUserId
    ) {
        Task task = new Task(title, description, dueDate, priority, assignedUserId);
        taskService.addTask(task);

        TaskHistory taskHistory = new TaskHistory(task.getTaskId(), assignedUserId, "Task Created");
        taskHistoryService.addTaskHistory(taskHistory);

        return task;
    }
}
