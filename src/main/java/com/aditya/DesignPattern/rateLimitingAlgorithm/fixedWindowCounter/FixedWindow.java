package com.aditya.DesignPattern.rateLimitingAlgorithm.fixedWindowCounter;

public class FixedWindow {

    private Integer windowSize;
    private Integer count;
    private Long currentStartTime;
    private Integer maxWindowCapacity;

    public FixedWindow(Integer windowSize, Integer maxWindowCapacity) {
        this.windowSize = windowSize;
        this.maxWindowCapacity = maxWindowCapacity;
        this.count = 0;
        this.currentStartTime = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        Long time = System.currentTimeMillis();
        int elapsedTime = (int) (time - currentStartTime) / 1000;

        if (elapsedTime >= windowSize) {
            count = 0;
            currentStartTime = time;
        }

        if (count < maxWindowCapacity) {
            count++;
            return true;
        }

        return false;
    }
}
