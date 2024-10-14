package com.aditya.DesignPattern.lld.multilevelCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUEvictionPolicy implements EvictionPolicy {

    private final LinkedHashMap<Integer, Boolean> accessOrderMap;

    public LRUEvictionPolicy(int capacity) {
        accessOrderMap = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Boolean> eldest) {
                return size() > capacity;
            }
        };
    }

    @Override
    public void keyAccessed(int key) {
        accessOrderMap.put(key, true);
    }

    @Override
    public int evictKey() {
        return accessOrderMap.keySet().iterator().next();
    }
}
