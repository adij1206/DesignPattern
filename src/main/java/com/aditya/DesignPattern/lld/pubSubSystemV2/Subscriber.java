package com.aditya.DesignPattern.lld.pubSubSystemV2;

import lombok.Data;

@Data
public class Subscriber {

    private String name;
    private Thread thread;
    private Boolean isActive;

    public Subscriber(String name) {
        this.name = name;
        isActive = true;
    }

    public void subscribe(Topic topic) {
        topic.subscribe(name);
        startConsumingMessages(topic);
    }

    private void startConsumingMessages(Topic topic) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isActive) {
                    int currentOffset = topic.getCurrentOffset(name);

                    if (currentOffset == -1) {
                        break;
                    }


                    Message message = topic.getMessageByOffSet(currentOffset);

                    if (message != null) {
                        System.out.println("Message : " + message.getContent() + "consumed by subscriber" + name);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        topic.updateOffsetForSubscriber(name, currentOffset + 1);
                    }

                }
            }

        });
        thread.start();
    }

    public void unsubscribe(Topic topic) {
        isActive = false;
        if (thread!=null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        topic.unsubscribe(name);
    }
}
