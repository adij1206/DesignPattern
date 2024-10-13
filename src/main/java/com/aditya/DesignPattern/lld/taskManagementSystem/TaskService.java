package com.aditya.DesignPattern.lld.taskManagementSystem;

import java.util.*;

public class TaskService {

    private Map<String, Task> taskMap;

    public TaskService() {
        this.taskMap = new HashMap<>();
    }

    public void addTask(Task task) {
        this.taskMap.put(task.getTaskId(), task);
    }

    public Task getTaskById(String taskId) {
        return taskMap.get(taskId);
    }

    public List<Task> getAllTaskByPriority(int priority) {
        List<Task> taskList = new ArrayList<>();

        for (Task task : this.taskMap.values()) {
            if (task.getPriority() == priority) {
                taskList.add(task);
            }
        }

        return taskList;
    }

    public List<Task> getAllTaskByAssignedUser(String assignedUserId) {
        List<Task> taskList = new ArrayList<>();

        for (Task task : this.taskMap.values()) {
            if (task.getAssignedUserId().equals(assignedUserId)) {
                taskList.add(task);
            }
        }

        return taskList;
    }

    public List<Task> getAllTaskByDueDate(Date dueDate) {
        List<Task> taskList = new ArrayList<>();

        for (Task task : this.taskMap.values()) {
            if (task.getDueDate().equals(dueDate)) {
                taskList.add(task);
            }
        }

        return taskList;
    }

    public void removeTask(String taskId) {
        this.taskMap.remove(taskId);
    }

    public Task updateTaskStatus(String taskId, TaskStatus status) {
        Task task = this.taskMap.get(taskId);
        task.setTaskStatus(status);
        return task;
    }

    public void updateAssignedUser(String taskId, String assignedUserId) {
        Task task = this.taskMap.get(taskId);
        task.setAssignedUserId(assignedUserId);
    }
}
