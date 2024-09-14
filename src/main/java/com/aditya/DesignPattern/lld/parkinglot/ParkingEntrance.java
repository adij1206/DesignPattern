package com.aditya.DesignPattern.lld.parkinglot;

import com.aditya.DesignPattern.lld.parkinglot.factory.ParkingManagerFactory;
import com.aditya.DesignPattern.lld.parkinglot.manager.ParkingSlotManager;

public class ParkingEntrance {

    private ParkingManagerFactory parkingManagerFactory;
    private ParkingSlotManager parkingSlotManager;

    public ParkingEntrance(ParkingManagerFactory parkingManagerFactory) {
        this.parkingManagerFactory = parkingManagerFactory;
    }

    public ParkingSlot findParkingSpace(VehicleType vehicleType) {
        this.parkingSlotManager = parkingManagerFactory.getParkingSlotManager(vehicleType);
        return parkingSlotManager.findParkingSlot();
    }

    public void parkVehicle(Vehicle vehicle, ParkingSlot parkingSlot) {
        parkingSlotManager.parkVehicle(vehicle, parkingSlot);
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        Ticket ticket = new Ticket();
        ticket.setTicketId("123");
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSlot);
        ticket.setStartTime(System.currentTimeMillis());

        return ticket;
    }
}
