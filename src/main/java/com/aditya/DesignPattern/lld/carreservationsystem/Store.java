package com.aditya.DesignPattern.lld.carreservationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Store {

    private String storeId;
    private Location location;
    private InventoryManagement inventoryManagement;
    private List<Reservation> reservations;

    public Store(String storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
        this.reservations = new ArrayList<>();
    }


    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public InventoryManagement getInventoryManagement() {
        return inventoryManagement;
    }

    public void setInventoryManagement(InventoryManagement inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setVehicle(List<Vehicle> vehicles) {
        this.inventoryManagement = new InventoryManagement(vehicles);
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return inventoryManagement.getVehicles(vehicleType);
    }

    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation(
                "1",
                vehicle,
                user,
                System.currentTimeMillis(),
                System.currentTimeMillis() + 1000L,
                System.currentTimeMillis() + 5000,
                ReservationStatus.SCHEDULED
        );

        reservations.add(reservation);
        System.out.println("Reservation created!" );
        return reservation;
    }

    public void updateReservation(String reservationId) {
        Optional<Reservation> optionalReservation = reservations.stream().filter(
                        reservation -> reservationId.equals(reservation.getId()))
                .findFirst();

        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setStatus(ReservationStatus.COMPLETED);
            System.out.println("Reservation Updated");
        }
    }
}
