package com.aditya.DesignPattern.rateLimitingAlgorithm.slidingWindowCounter;

import com.aditya.DesignPattern.rateLimitingAlgorithm.slidingWindowLog.SlidingWindow;

public class SlidingWindowCounterAlgorithm {

    public static void main(String[] args) throws InterruptedException {
        SlidingWindow slidingWindow = new SlidingWindow(10, 5);

        for (int i = 0; i < 10; i++) {
            System.out.println(slidingWindow.allowRequest());
        }

        Thread.sleep(3000);

        System.out.println(slidingWindow.allowRequest());
    }
}
