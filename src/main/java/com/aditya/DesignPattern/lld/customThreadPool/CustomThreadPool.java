package com.aditya.DesignPattern.lld.customThreadPool;

import java.util.LinkedList;
import java.util.Queue;

public class CustomThreadPool {

    private Thread[] thread;
    private final Queue<Runnable> runnables;

    public CustomThreadPool(int noOfThreads) {
        thread = new Thread[noOfThreads];
        runnables = new LinkedList<>();
        startThreads();
    }

    public void startThreads() {
        for (int i = 0; i < thread.length; i++) {
            int finalI = i;
            thread[i] = new Thread(() -> consume(finalI));
            thread[i].start();
        }
    }

    private void consume(int i) {
        while (true) {
            Runnable runnable;

            synchronized (runnables) {
                while (runnables.isEmpty()) {
                    try {
                        System.out.println("thread " + i + " is waiting");
                        runnables.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                runnable = runnables.poll();
                System.out.println("Thread" + i + "is consuming the task");
            }

            runnable.run();
        }
    }

    public void execute(Runnable runnable) {
        synchronized (runnables) {
            runnables.add(runnable);
            runnables.notifyAll();
        }
    }
}
