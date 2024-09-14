package com.aditya.DesignPattern.pattern.v2;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args) {
        Observer mobileObserver = new MobileObserver();
        Observer emailObserver = new EmailObserver();

        IPhoneObservable iPhoneObservable = new IPhoneObservable();
        iPhoneObservable.registerObserver(mobileObserver);
        iPhoneObservable.registerObserver(emailObserver);

        iPhoneObservable.setCount(1);
    }
}

interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAllObservers();
}

class IPhoneObservable implements Observable {

    public List<Observer> observerList = new ArrayList<>();
    public int count = 0;

    public IPhoneObservable() {}

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public void setCount(int count) {
        if (this.count ==0) {
            notifyAllObservers();
        }

        this.count+=count;
    }
}

interface Observer {
    void update();
}

class EmailObserver implements Observer {

    @Override
    public void update() {
        System.out.println("Email Notification received");
    }
}

class MobileObserver implements Observer {

    @Override
    public void update() {
        System.out.println("Mobile Notification Received");
    }
}