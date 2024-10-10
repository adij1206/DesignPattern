package com.aditya.DesignPattern.lld.loggingFramework;

public enum LogLevel {
    ERROR(40),
    INFO(30),
    WARN(20),
    DEBUG(10);

    private int priority;

    LogLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
