package com.aditya.DesignPattern.pattern.behaviour;

import java.util.ArrayList;
import java.util.List;

/*
 * This Pattern is best example of Kafka
 */

interface Subject {

    void registerObserver(Observer observer);
    void unRegisterObserver(Observer observer);
    void notifyObservers();
}

class DeliveryData implements Subject {
    private List<Observer> observerList;
    private String location;

    public DeliveryData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(location);
        }
    }

    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation() {
        return "YPlace";
    }
}

interface Observer {
    void update(String location);
}

class User implements Observer {
    private String location;
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

class DeliveryWareHouse implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Delivery WareHouse - Current Location: " + location);
    }
}
public class ObserverDesignPattern {

    public static void main(String[] args) {
        DeliveryData deliveryData = new DeliveryData();

        User user = new User();
        Seller seller = new Seller();
        DeliveryWareHouse deliveryWareHouse = new DeliveryWareHouse();

        deliveryData.registerObserver(user);
        deliveryData.registerObserver(seller);
        deliveryData.registerObserver(deliveryWareHouse);

        deliveryData.locationChanged();

        deliveryData.unRegisterObserver(seller);
        System.out.println();
        deliveryData.locationChanged();
    }
}
