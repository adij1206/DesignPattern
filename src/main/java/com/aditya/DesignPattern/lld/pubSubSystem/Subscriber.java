package com.aditya.DesignPattern.lld.pubSubSystem;

public class Subscriber {

    private String name;

    public Subscriber(String name) {
        this.name = name;
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

    public void subscribeWithOffset(TopicWithOffset topic) {
        new Thread(() -> {
            while (true) {
                int offset = topic.getOffset(Subscriber.this);

                Message messageByOffset = topic.getMessageByOffset(offset);
                if (messageByOffset != null) {
                    System.out.println(messageByOffset.content);
                    topic.updateOffset(Subscriber.this, offset + 1);
                }
            }
        }).start();
    }
}
