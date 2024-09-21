package com.aditya.DesignPattern.lld.pubSubSystem.pushBased;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Broker {

    private Map<String, Topic> topicMap;
    private Map<Topic, List<Subscriber>> topicSubscribersMap;

    public Broker() {
        topicMap = new HashMap<>();
        topicSubscribersMap = new HashMap<>();
    }

    public void createTopic(String topicName) {
        Topic topic = new Topic(topicName);
        topicMap.put(topicName, topic);
    }

    public Topic getTopicByName(String name) {
        return topicMap.get(name);
    }

    public void publish(Message message, String topicName) {
        Topic topic = topicMap.get(topicName);
        //topic.addMessage(message);

        //push based : need to notify all the subscriber
        List<Subscriber> subscriberList = topicSubscribersMap.getOrDefault(topic, new ArrayList<>());
        notifySubscribers(subscriberList, message);
    }

    public void subscribeToTopic(String topicName, Subscriber subscriber) {
        Topic topic = topicMap.get(topicName);
        List<Subscriber> subscriberList = topicSubscribersMap.getOrDefault(topic, new ArrayList<>());
        subscriberList.add(subscriber);
        topicSubscribersMap.put(topic, subscriberList);
    }

    private void notifySubscribers(List<Subscriber> subscribers, Message message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.send(message);
        }
    }
}
