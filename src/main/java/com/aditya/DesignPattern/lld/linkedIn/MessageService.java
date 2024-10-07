package com.aditya.DesignPattern.lld.linkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService {

    private Map<String, Message> messageMap;

    public MessageService() {
        messageMap = new HashMap<>();
    }

    public void addMessage(String senderUserId, String receiverUserId, String content) {
        Message message = new Message(senderUserId, receiverUserId, content);
        this.messageMap.put(message.getMessageId(), message);
    }

    public List<Message> getChatForAUser(String userId1, String userId2) {
        List<Message> messages = new ArrayList<>();

        for (Message message : messageMap.values()) {
            if ((message.getReceiverUserId().equals(userId1) && message.getSenderUserId().equals(userId2)) ||
                    (message.getReceiverUserId().equals(userId2) && message.getSenderUserId().equals(userId1))) {
                messages.add(message);
            }
        }

        return messages;
    }
}
