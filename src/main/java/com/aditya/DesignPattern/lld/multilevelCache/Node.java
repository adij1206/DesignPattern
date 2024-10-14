package com.aditya.DesignPattern.lld.multilevelCache;

import lombok.Data;

@Data
public class Node {

    private Node next;
    private Node prev;
    private int key;
    private int value;

    public Node(int key, int val) {
        this.key = key;
        this.value = val;
    }
}
