package com.aditya.DesignPattern.lld.taskManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskHistoryService {

    private Map<String, TaskHistory> taskHistoryMap;

    public TaskHistoryService() {
        this.taskHistoryMap = new HashMap<>();
    }

    public void addTaskHistory(TaskHistory taskHistory) {
        this.taskHistoryMap.put(taskHistory.getId(), taskHistory);
    }

    public TaskHistory getTaskHistoryById(String id) {
        return taskHistoryMap.get(id);
    }

    public List<TaskHistory> getHistoryForTask(String taskId) {
        List<TaskHistory> taskHistoryList = new ArrayList<>();

        for (TaskHistory taskHistory : taskHistoryMap.values()) {
            if (taskHistory.getTaskId().equals(taskId)) {
                taskHistoryList.add(taskHistory);
            }
        }

        return taskHistoryList;
    }
}
