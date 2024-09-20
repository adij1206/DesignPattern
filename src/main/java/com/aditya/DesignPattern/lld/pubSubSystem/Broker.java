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
}
