package com.aditya.DesignPattern.lld.multilevelCache;

import java.util.HashMap;
import java.util.Map;

public abstract class Cache {

    protected int capacity;
    protected Map<Integer, Integer> map;
    protected Cache nextLevel;
    protected EvictionPolicy evictionPolicy;

    public Cache(int capacity, EvictionPolicy evictionPolicy) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.evictionPolicy = evictionPolicy;
    }

    public void setNextLevel(Cache nextLevel) {
        this.nextLevel = nextLevel;
    }

    public abstract Integer get(Integer key);

    protected abstract void set(Integer key, Integer value);
}
