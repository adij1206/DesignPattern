package com.aditya.DesignPattern.lld.carReservationSystem;

public class Vehicle {

    private String vehicleNo;
    private VehicleType vehicleType;
    private String status;

    public Vehicle(){}

    public Vehicle(String vehicleNo, VehicleType vehicleType, String status) {
        this.vehicleNo = vehicleNo;
        this.status = status;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
