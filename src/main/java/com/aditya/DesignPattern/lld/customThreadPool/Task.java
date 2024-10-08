package com.aditya.DesignPattern.lld.customThreadPool;

public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Running task " + name);
    }
}
