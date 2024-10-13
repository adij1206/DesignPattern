package com.aditya.DesignPattern.lld.lruCache;

import lombok.Data;

@Data
public class Node {

    private Node next;
    private Node prev;
    private int key;
    private int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
