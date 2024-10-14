package com.aditya.DesignPattern.lld.multilevelCache;

public class L1Cache extends Cache {
    public L1Cache(int capacity, EvictionPolicy evictionPolicy) {
        super(capacity, evictionPolicy);
    }

    @Override
    public Integer get(Integer key) {
        if (map.containsKey(key)) {
            evictionPolicy.keyAccessed(key);
            return map.get(key);
        } else if (nextLevel != null) {
            Integer value = nextLevel.get(key);
            if (value != null) {
                set(key, value);  // Backfill the data
            }
            return value;
        }
        return null;
    }

    @Override
    public void set(Integer key, Integer value) {
        if(map.containsKey(key) && value==map.get(key)) {
            return;
        }

        if (map.size() == capacity) {
            int evictedKey = evictionPolicy.evictKey();
            map.remove(evictedKey);
        }
        map.put(key, value);
        evictionPolicy.keyAccessed(key);
        if (nextLevel != null) {
            nextLevel.set(key, value);
        }
    }
}