package com.aditya.DesignPattern.rateLimitingAlgorithm.tokenBucketAlgorithm;

public class TokenBucket {

    private Integer capacity;
    private Integer fillRate;
    private Integer tokens;
    private Long lastTime;

    public TokenBucket(Integer capacity, Integer fillRate) {
        this.capacity = capacity;
        this.fillRate = fillRate;
        this.lastTime = System.currentTimeMillis();
        this.tokens = capacity;
    }

    public boolean addToken(Integer tokens) {
        Long currentTime = System.currentTimeMillis();

        Integer tokensAvailable = Math.min(capacity, this.tokens + (int) (currentTime - lastTime) * fillRate / 1000);
        this.lastTime = currentTime;

        if (tokensAvailable >= tokens) {
            this.tokens = tokensAvailable - tokens;
            return true;
        }

        this.tokens = tokensAvailable;
        return false;
    }
}
