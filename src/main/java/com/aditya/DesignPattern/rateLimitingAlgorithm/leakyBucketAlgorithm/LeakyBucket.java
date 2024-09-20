package com.aditya.DesignPattern.rateLimitingAlgorithm.leakyBucketAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket {

    private Integer capacity;
    private Integer leakRate;
    private Queue<Long> bucket;
    private Long leakTime;

    public LeakyBucket(Integer capacity, Integer leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.bucket = new LinkedList<>();
        leakTime = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        Long currentTime = System.currentTimeMillis();

        Long leakedTime = currentTime - this.leakTime;
        int leaked = (int) (leakedTime * leakRate / 1000);

        if (leaked > 0) {
            for (int i = 0; i < Math.min(leaked, capacity); i++) {
                bucket.poll();
            }
            this.leakTime = currentTime;
        }

        if (bucket.size() < capacity) {
            bucket.add(currentTime);
            return true;
        }

        return false;
    }
}
