package com.aditya.DesignPattern.lld.taskManagementSystem;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Task {

    private String taskId;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private TaskStatus taskStatus;
    private String assignedUserId;

    public Task(String title, String description, Date dueDate, int priority, String assignedUserId) {
        this.taskId = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        taskStatus = TaskStatus.TODO;
        this.assignedUserId = assignedUserId;
    }
}
