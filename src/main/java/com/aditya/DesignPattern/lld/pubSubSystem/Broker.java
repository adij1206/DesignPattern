package com.aditya.DesignPattern.lld.pubSubSystem;

import java.util.HashMap;
import java.util.Map;

public class Broker {

    private Map<String, Topic> topics;
    private Map<String, TopicWithOffset> topicWithOffSetMap;

    public Broker() {
        topics = new HashMap<>();
        topicWithOffSetMap = new HashMap<>();
    }

    public Topic createTopic(String name) {
        Topic topic = new Topic(name);
        topics.put(name, topic);
        return topic;
    }

    public TopicWithOffset createTopicWithOffset(String name) {
        TopicWithOffset topic = new TopicWithOffset(name);
        topicWithOffSetMap.put(name, topic);
        return topic;
    }

    public Topic getTopic(String name) {
        return topics.get(name);
    }

    public TopicWithOffset getTopicWithOffset(String name) {
        return topicWithOffSetMap.get(name);
    }

    public void publishMessage(String topic, Message message) {
        TopicWithOffset topicObj = topicWithOffSetMap.get(topic);
        if (topicObj == null) {
            System.out.println("Topic " + topic + " not found");
            return;
        }

        topicObj.addMessage(message);
    }


    public Message getMessageByOffset(int offset, String topicName) {
        TopicWithOffset topicObj = topicWithOffSetMap.get(topicName);

        return topicObj.getMessageByOffset(offset);
    }

    public int getOffset(String topicName, String subscriberName) {
        TopicWithOffset topicObj = topicWithOffSetMap.get(topicName);
        return topicObj.getSubscriptionOffset(subscriberName);
    }

    public void updateOffset(String topicName, String subscriberName, int offset) {
        TopicWithOffset topicObj = topicWithOffSetMap.get(topicName);

        topicObj.updateOffset(subscriberName, offset);
    }
}
