package com.aditya.DesignPattern.pattern.creation;

interface Vehicle {
    int getNoOfWheels();
}

class Car implements Vehicle {
    private int wheels;

    public Car(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public int getNoOfWheels() {
        return this.wheels;
    }
}

class Bike implements Vehicle {
    private int wheels;

    public Bike(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public int getNoOfWheels() {
        return this.wheels;
    }
}

class FactoryVehicle {
    public static Vehicle getInstance(String type, int wheels) {
        if (type == "car") {
            return new Car(wheels);
        } else if (type == "bike") {
            return new Bike(wheels);
        }

        return null;
    }
}


public class FactoryDesignPattern {
    public static void main(String[] args) {
        Vehicle car = FactoryVehicle.getInstance("car", 4);

        Vehicle bike = FactoryVehicle.getInstance("bike", 2);

        //Based on the Type we are passing , we will get the instance of the Vehicle.

        System.out.println(car.getNoOfWheels());
        System.out.println(bike.getNoOfWheels());
    }
}
