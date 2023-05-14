package com.aditya.DesignPattern.pattern.creation;

class Vehicles {

    //required
    private int wheels;
    private String type;

    //optional
    private int airBags;

    private Vehicles(VehicleBuilder vehicleBuilder) {
        this.type = vehicleBuilder.type;
        this.airBags = vehicleBuilder.airBags;
        this.wheels = vehicleBuilder.wheels;
    }

    // Only getters needed, no need of setter as we are using Builder for setting fields.
    public int getWheels() {
        return wheels;
    }

    public String getType() {
        return type;
    }

    public int getAirBags() {
        return airBags;
    }

    public static class VehicleBuilder {
        private int wheels;
        private String type;

        private int airBags;

        public VehicleBuilder(int wheels, String type) {
            this.wheels = wheels;
            this.type = type;
        }

        public VehicleBuilder setAirBags(int airBags) {
            this.airBags = airBags;
            return this;
        }

        public Vehicles build() {
            return new Vehicles(this);
        }
    }
}

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Vehicles car = new Vehicles.VehicleBuilder(4, "car").setAirBags(6).build();
        Vehicles bike = new Vehicles.VehicleBuilder(2, "bike").build();

        System.out.println(car.getType());
        System.out.println(car.getAirBags());
        System.out.println(car.getWheels());

        System.out.println(bike.getType());
        System.out.println(bike.getAirBags());
        System.out.println(bike.getWheels());
    }
}
