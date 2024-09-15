package com.aditya.DesignPattern.lld.carreservationsystem;

import java.util.List;

public class VehicleReservationSystem {

    private List<Store> storeList;
    private List<User> customerList;

    public VehicleReservationSystem(List<Store> storeList, List<User> customerList) {
        this.storeList = storeList;
        this.customerList = customerList;
    }

    public Store getStoreBasedOnLocation(Location location) {
        // TODO : Return based on filter in location
        return storeList.get(0);
    }

}
