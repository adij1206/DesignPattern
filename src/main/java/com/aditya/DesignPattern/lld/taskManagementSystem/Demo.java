package com.aditya.DesignPattern.lld.taskManagementSystem;

import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        User user1 = new User("abc@yopmail.com", "Aditya");
        User user2 = new User("abd@yopmail.com", "Manish");
        User user3 = new User("abe@yopmail.com", "Paras");

        TaskManagementService taskManagementService = TaskManagementService.getInstance();

        taskManagementService.addUser(user1);
        taskManagementService.addUser(user2);
        taskManagementService.addUser(user3);

        Task task = taskManagementService.createTask(
                "Create", "Task ManagementService", new Date(), 1, user1.getEmail());
        System.out.println(task);

        Task task1 = taskManagementService.createTask(
                "Update", "Task ManagementService", new Date(), 2, user1.getEmail());
        System.out.println(task1);

        Task task2 = taskManagementService.createTask(
                "Create", "Task ManagementService", new Date(), 1, user2.getEmail());
        System.out.println(task2);

        System.out.println("Task by assignedUSerId" + taskManagementService.getAllTaskByAssignedUser(user1.getEmail()));
        System.out.println("Task by priority" + taskManagementService.getAllTaskByPriority(1));

        taskManagementService.updateTaskStatus(task.getTaskId(), TaskStatus.ASSIGNED);
        System.out.println(taskManagementService.getTaskById(task.getTaskId()));

        taskManagementService.updateAssignedUser(task.getTaskId(), user3.getEmail());

        taskManagementService.updateTaskStatus(task.getTaskId(), TaskStatus.COMPLETED);
        System.out.println(taskManagementService.getTaskById(task.getTaskId()));

        System.out.println(taskManagementService.getHistoryForTask(task.getTaskId()));
    }
}
