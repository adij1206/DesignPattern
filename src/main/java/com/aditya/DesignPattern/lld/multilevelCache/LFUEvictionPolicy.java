package com.aditya.DesignPattern.lld.multilevelCache;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUEvictionPolicy implements EvictionPolicy {
    private final Map<Integer, Integer> frequencyMap;
    private final PriorityQueue<Integer> minHeap;

    public LFUEvictionPolicy() {
        frequencyMap = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));
    }

    @Override
    public void keyAccessed(int key) {
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
        minHeap.add(key);
    }

    @Override
    public int evictKey() {
        return minHeap.poll();
    }
}

