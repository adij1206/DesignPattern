package com.aditya.DesignPattern.lld.multilevelCache;

public interface EvictionPolicy {

    void keyAccessed(int key);
    int evictKey();
}
