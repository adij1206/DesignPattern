package com.aditya.DesignPattern.lld.googleDrive;

public enum Permission {
    NONE(0),
    READ(5),
    WRITE(10),
    ADMIN(15);

    private int priority;

    Permission(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
