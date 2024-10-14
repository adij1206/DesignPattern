package com.aditya.DesignPattern.lld.multilevelCache;

public class MultiLevelCache {

    private L1Cache l1Cache;
    private L2Cache l2Cache;

    public MultiLevelCache(int l1capacity, int l2capacity) {
        l1Cache = new L1Cache(l1capacity, new LRUEvictionPolicy(l1capacity));
        l2Cache = new L2Cache(l2capacity, new LFUEvictionPolicy());

        l1Cache.setNextLevel(l2Cache);
    }

    public Integer getData(Integer key) {
        return l1Cache.get(key);
    }

    public void setData(Integer key, Integer value) {
        l1Cache.set(key, value);
    }
}
