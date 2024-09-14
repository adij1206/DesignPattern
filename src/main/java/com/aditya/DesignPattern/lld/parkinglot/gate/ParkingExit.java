package com.aditya.DesignPattern.lld.parkinglot.gate;

import com.aditya.DesignPattern.lld.parkinglot.CostComputation;
import com.aditya.DesignPattern.lld.parkinglot.Ticket;
import com.aditya.DesignPattern.lld.parkinglot.factory.CostComputationFactory;
import com.aditya.DesignPattern.lld.parkinglot.factory.ParkingManagerFactory;
import com.aditya.DesignPattern.lld.parkinglot.manager.ParkingSlotManager;

import java.math.BigDecimal;

public class ParkingExit {

    private CostComputationFactory costComputationFactory;
    private ParkingManagerFactory parkingManagerFactory;

    public ParkingExit(CostComputationFactory costComputationFactory, ParkingManagerFactory parkingManagerFactory) {
        this.costComputationFactory = costComputationFactory;
        this.parkingManagerFactory = parkingManagerFactory;
    }

    public void unParkVehicle(Ticket ticket) {
        ParkingSlotManager parkingSlotManager = parkingManagerFactory.getParkingSlotManager(
                ticket.getVehicle().getVehicleType());
        parkingSlotManager.unParkVehicle(ticket.getVehicle(), ticket.getParkingSpot());
    }

    public BigDecimal computeCost(Ticket ticket) {
        CostComputation costComputation = costComputationFactory.getCostComputation(
                ticket.getVehicle().getVehicleType());
        return costComputation.computeCost(ticket);
    }
}
