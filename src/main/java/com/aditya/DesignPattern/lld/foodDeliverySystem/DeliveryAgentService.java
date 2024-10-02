package com.aditya.DesignPattern.lld.foodDeliverySystem;

import java.util.HashMap;
import java.util.Map;

public class DeliveryAgentService {

    private Map<String, DeliveryAgent> deliveryAgents;

    public DeliveryAgentService() {
        deliveryAgents = new HashMap<>();
    }

    public void addDeliveryAgent(DeliveryAgent deliveryAgent) {
        deliveryAgents.put(deliveryAgent.getId(), deliveryAgent);
    }

    public DeliveryAgent getDeliveryAgent() {
       for (DeliveryAgent deliveryAgent : deliveryAgents.values()) {
           if (deliveryAgent.isAvailable()) {
               return deliveryAgent;
           }
       }

       return null;
    }

    public void updateDeliveryAgentAvailability(String id, boolean isAvailable) {
        DeliveryAgent deliveryAgent = deliveryAgents.get(id);
        if (deliveryAgent != null) {
            deliveryAgent.setAvailable(isAvailable);
        }
    }
}
