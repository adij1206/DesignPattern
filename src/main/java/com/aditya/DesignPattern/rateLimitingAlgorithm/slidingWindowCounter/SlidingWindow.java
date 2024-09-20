package com.aditya.DesignPattern.rateLimitingAlgorithm.slidingWindowCounter;

public class SlidingWindow {

    private int windowSize;
    private int maxCount;
    private int previousWindowCount;
    private int currentWindowCount;
    private Long currentWindowStartTime;

    public SlidingWindow(int windowSize, int maxCount) {
        this.windowSize = windowSize;
        this.maxCount = maxCount;
        this.currentWindowCount = 0;
        this.previousWindowCount = 0;
        this.currentWindowStartTime = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        Long currentTime = System.currentTimeMillis();
        long timeElapsed = (currentTime - this.currentWindowStartTime)/1000;

        // moved to new window
        if (timeElapsed >= windowSize) {
            previousWindowCount = currentWindowCount;
            currentWindowCount = 0;
            currentWindowStartTime = currentTime;
            timeElapsed = 0L;
        }

        double weight = previousWindowCount * ((windowSize - timeElapsed) / (double) windowSize) + currentWindowCount;

        if (weight <= maxCount) {
            currentWindowCount++;
            return true;
        }

        return false;
    }
}
