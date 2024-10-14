package com.aditya.DesignPattern.lld.multilevelCache;

public class CacheDemo {

    public static void main(String[] args) {
        MultiLevelCache multiLevelCache = new MultiLevelCache(2, 3);

        multiLevelCache.setData(1,3);
        multiLevelCache.setData(2,4);
        multiLevelCache.setData(3,5);

        System.out.println(multiLevelCache.getData(1));
        System.out.println(multiLevelCache.getData(1));
        System.out.println(multiLevelCache.getData(2));
        System.out.println(multiLevelCache.getData(3));
    }
}
