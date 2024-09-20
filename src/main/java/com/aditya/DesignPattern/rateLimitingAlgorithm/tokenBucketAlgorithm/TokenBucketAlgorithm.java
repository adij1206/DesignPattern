package com.aditya.DesignPattern.rateLimitingAlgorithm.tokenBucketAlgorithm;

public class TokenBucketAlgorithm {

    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(10, 1);

        for (int i=0;i<15;i++) {
            Thread.sleep(1000);
            System.out.println(tokenBucket.addToken(2));
        }
    }
}
