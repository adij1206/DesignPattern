package com.aditya.DesignPattern.lld.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.setNext(tail);
        tail.setPrev(head);

        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);

            return node.getValue();
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (capacity == map.size()) {
            remove(tail.getPrev());
        }

        insert(new Node(key, value));
    }

    private void remove(Node node) {
        Node prev = node.getPrev();
        Node next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);

        map.remove(node.getKey());
    }

    private void insert(Node node) {
        map.put(node.getKey(), node);

        node.setNext(head.getNext());
        head.getNext().setPrev(node);
        head.setNext(node);
        node.setPrev(head);
    }
}
