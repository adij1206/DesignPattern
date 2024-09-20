package com.aditya.DesignPattern.rateLimitingAlgorithm.slidingWindowLogAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow {

    private int windowSize;
    private int maxRequest;
    private Queue<Long> queue;

    public SlidingWindow(int windowSize, int maxRequest) {
        this.windowSize = windowSize;
        this.maxRequest = maxRequest;
        this.queue = new LinkedList<>();
    }

    public boolean allowRequest() {
        Long currentTime = System.currentTimeMillis();

        if (!queue.isEmpty() && ((currentTime - queue.peek()) / 1000) > windowSize) {
            queue.poll();
        }

        if (queue.size() <= maxRequest) {
            queue.offer(currentTime);
            return true;
        }

        return false;
    }
}
