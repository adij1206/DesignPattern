package com.aditya.DesignPattern.lld.pubSubSystemV2;

public class PubSubSystem {

    public static void main(String[] args) {
        Topic topic = new Topic("Topic1");

        Publisher publisher1 = new Publisher("Publisher1");

        Subscriber subscriber1 = new Subscriber("Subscriber1");
        Subscriber subscriber2 = new Subscriber("Subscriber2");

        subscriber1.subscribe(topic);
        subscriber2.subscribe(topic);

        publisher1.publishMessage(topic, "Hi!");
        publisher1.publishMessage(topic, "This is a message");

        subscriber1.unsubscribe(topic);

        publisher1.publishMessage(topic, "This is a message2");
    }
}
