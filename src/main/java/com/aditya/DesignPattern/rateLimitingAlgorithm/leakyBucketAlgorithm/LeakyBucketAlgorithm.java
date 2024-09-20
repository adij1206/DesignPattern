package com.aditya.DesignPattern.rateLimitingAlgorithm.leakyBucketAlgorithm;

public class LeakyBucketAlgorithm {

    public static void main(String[] args) throws InterruptedException {
        LeakyBucket leakyBucket = new LeakyBucket(5, 1);

        for (int i=0;i<5;i++) {
            System.out.println(leakyBucket.allowRequest());
        }

        Thread.sleep(2000);
        for (int i=0;i<5;i++) {
            System.out.println(leakyBucket.allowRequest());
        }
    }
}
