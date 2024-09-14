package com.aditya.DesignPattern.pattern.v2;

/*
 * Strategy Pattern : provides different variant of algorithm within an object
 * and be able to switch from one algorithm to another
 * Client will be responsible to decide which strategy which needs to be used.
 * Or we can use Factory method to decide the strategy.
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Vehicle vehicle = new NormalVehicle();
        vehicle.drive();
    }
}

class Vehicle {

    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}

class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SpecialDriveStrategy());
    }
}

class NormalVehicle extends Vehicle {

    public NormalVehicle() {
        super(new NormalDriveStrategy());
    }
}


interface DriveStrategy {

    void drive();
}

class SpecialDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Driving with SpecialDriveStrategy");
    }
}

class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Driving with NormalDriveStrategy");
    }
}