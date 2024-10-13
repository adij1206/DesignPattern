package com.aditya.DesignPattern.lld.lruCache;

public class Demo {

    public static void main(String[] args) {
        LruCache cache = new LruCache(3);

        cache.put(1, 4);
        cache.put(2, 5);
        cache.put(3, 6);
        System.out.println(cache.get(3));
        cache.put(4, 7);
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
    }
}
