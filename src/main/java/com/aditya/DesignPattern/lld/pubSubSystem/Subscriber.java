package com.aditya.DesignPattern.lld.pubSubSystem;

import java.util.HashMap;
import java.util.Map;

public class Subscriber {

    private String name;
    private Map<String, Thread> stringThreadMap;

    public Subscriber(String name) {
        this.name = name;
        stringThreadMap = new HashMap<String, Thread>();
    }

    public void subscribe(Topic topic) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (topic.hasNext()) {
                        Message next = topic.next();
                        System.out.println(next.content);
                    }
                }

            }
        }).start();
    }

//    public void subscribeWithOffset(TopicWithOffset topic) {
//        new Thread(() -> {
//            while (true) {
//                int offset = topic.getOffset(Subscriber.this);
//
//                Message messageByOffset = topic.getMessageByOffset(offset);
//                if (messageByOffset != null) {
//                    System.out.println(messageByOffset.content);
//                    topic.updateOffset(Subscriber.this, offset + 1);
//                }
//            }
//        }).start();
//    }

    public void subscribeWithOffset(Broker broker, String topic) {
        Thread thread = new Thread(() -> {
            while (true) {
                int offset = broker.getOffset(topic, this.name);

                Message messageByOffset = broker.getMessageByOffset( offset, topic);
                if (messageByOffset != null) {
                    System.out.println(messageByOffset.content);
                    broker.updateOffset(topic, this.name, offset + 1);
                }
            }
        });

        stringThreadMap.put(topic, thread);
        thread.start();
    }

    public void unsubscribe(String topic) {
        Thread thread = stringThreadMap.get(topic);
        thread.stop();
        stringThreadMap.remove(topic);
    }
}