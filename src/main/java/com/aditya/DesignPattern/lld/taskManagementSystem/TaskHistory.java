package com.aditya.DesignPattern.lld.taskManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskHistory {

    private String id;
    private String taskId;
    private String assignedUser;
    private String activity;

    public TaskHistory(String taskId, String assignedUser, String activity) {
        this.id = UUID.randomUUID().toString();
        this.taskId = taskId;
        this.assignedUser = assignedUser;
        this.activity = activity;
    }
}
