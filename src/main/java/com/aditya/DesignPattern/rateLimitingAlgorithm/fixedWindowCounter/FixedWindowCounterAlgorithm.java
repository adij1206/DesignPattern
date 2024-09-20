package com.aditya.DesignPattern.rateLimitingAlgorithm.fixedWindowCounter;

public class FixedWindowCounterAlgorithm {

    public static void main(String[] args) throws InterruptedException {
        FixedWindow fixedWindow = new FixedWindow(1, 4);

        for (int i=0;i<5;i++) {
            System.out.println(fixedWindow.allowRequest());
        }

        Thread.sleep(3000);

        for (int i=0;i<5;i++) {
            System.out.println(fixedWindow.allowRequest());
        }
    }
}
