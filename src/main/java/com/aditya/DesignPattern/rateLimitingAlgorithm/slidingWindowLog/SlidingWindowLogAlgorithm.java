package com.aditya.DesignPattern.rateLimitingAlgorithm.slidingWindowLog;

public class SlidingWindowLogAlgorithm {

    public static void main(String[] args) throws InterruptedException {
        SlidingWindow slidingWindow = new SlidingWindow(10, 5);

        for (int i=0;i<7;i++) {
            System.out.println(slidingWindow.allowRequest());
            Thread.sleep(1000);
        }
    }
}
