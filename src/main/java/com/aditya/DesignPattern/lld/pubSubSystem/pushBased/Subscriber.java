package com.aditya.DesignPattern.lld.pubSubSystem.pushBased;

public class Subscriber {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void send(Message message) {
        System.out.println(this.name + " received a message: " + message.getContent());
    }
}
