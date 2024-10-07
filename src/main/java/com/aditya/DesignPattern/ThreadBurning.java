package com.aditya.DesignPattern;

public class ThreadBurning {

    private static Integer timer = 0;
    private static Integer lock = 0;

    public static void main(String[] args) {
        java.lang.Thread thread1 = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    burnThread(timer, 60);
                    lock.notify();
                }
            }
        });

        java.lang.Thread thread2 = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    burnThread(timer, 60);
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void burnThread(Integer timer, Integer i) {
        while (timer < i) {
            System.out.println("Timer" + timer);
            timer++;
            i--;
        }
    }
}
