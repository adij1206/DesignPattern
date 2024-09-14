package com.aditya.DesignPattern.lld.parkinglot;

import com.aditya.DesignPattern.lld.parkinglot.factory.CostComputationFactory;
import com.aditya.DesignPattern.lld.parkinglot.factory.ParkingManagerFactory;
import com.aditya.DesignPattern.lld.parkinglot.gate.ParkingExit;
import com.aditya.DesignPattern.lld.parkinglot.manager.FourWheelerParkingSlotManager;
import com.aditya.DesignPattern.lld.parkinglot.manager.TwoWheelerParkingSlotManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotDemo {

    public static void main(String[] args) {
        List<ParkingSlot> twoWheelerParkingSlots = new ArrayList<>();
        twoWheelerParkingSlots.add(new TwoWheelerParkingSlot(
                "1", true, new BigDecimal(10), VehicleType.TWO_WHEELER.name()));
        twoWheelerParkingSlots.add(new TwoWheelerParkingSlot(
                "2", true, new BigDecimal(10), VehicleType.TWO_WHEELER.name()));
        twoWheelerParkingSlots.add(new TwoWheelerParkingSlot(
                "3", true, new BigDecimal(10), VehicleType.TWO_WHEELER.name()));
        twoWheelerParkingSlots.add(new TwoWheelerParkingSlot(
                "4", true, new BigDecimal(10), VehicleType.TWO_WHEELER.name()));
        TwoWheelerParkingSlotManager twoWheelerParkingSlotManager = new TwoWheelerParkingSlotManager(
                twoWheelerParkingSlots);

        List<ParkingSlot> fourWheelerParkingSlots = new ArrayList<>();
        fourWheelerParkingSlots.add(new FourWheelerParkingSlot(
                "1", true, new BigDecimal(20), VehicleType.FOUR_WHEELER.name()));
        fourWheelerParkingSlots.add(new FourWheelerParkingSlot(
                "2", true, new BigDecimal(20), VehicleType.FOUR_WHEELER.name()));
        fourWheelerParkingSlots.add(new FourWheelerParkingSlot(
                "3", true, new BigDecimal(20), VehicleType.FOUR_WHEELER.name()));
        fourWheelerParkingSlots.add(new FourWheelerParkingSlot(
                "4", true, new BigDecimal(20), VehicleType.FOUR_WHEELER.name()));
        FourWheelerParkingSlotManager fourWheelerParkingSlotManager = new FourWheelerParkingSlotManager(
                fourWheelerParkingSlots);

        ParkingManagerFactory parkingManagerFactory = new ParkingManagerFactory(
                twoWheelerParkingSlotManager, fourWheelerParkingSlotManager);

        ParkingEntrance parkingEntrance = new ParkingEntrance(parkingManagerFactory);

        // First vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("123");
        vehicle.setVehicleType(VehicleType.TWO_WHEELER);

        // Second Vehicle
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleNumber("123");
        vehicle1.setVehicleType(VehicleType.FOUR_WHEELER);

        ParkingSlot parkingSlot1 = parkingEntrance.findParkingSpace(vehicle.getVehicleType());
        parkingEntrance.parkVehicle(vehicle, parkingSlot1);
        Ticket ticket = parkingEntrance.generateTicket(vehicle, parkingSlot1);

        ParkingSlot parkingSlot2 = parkingEntrance.findParkingSpace(vehicle1.getVehicleType());
        parkingEntrance.parkVehicle(vehicle1, parkingSlot2);
        Ticket ticket1 = parkingEntrance.generateTicket(vehicle1, parkingSlot2);

        FourWheelerCostComputation fourWheelerCostComputation = new FourWheelerCostComputation();
        TwoWheelerCostComputation twoWheelerCostComputation = new TwoWheelerCostComputation();

        CostComputationFactory costComputationFactory = new CostComputationFactory(
                twoWheelerCostComputation, fourWheelerCostComputation);

        ParkingExit parkingExit = new ParkingExit(costComputationFactory, parkingManagerFactory);

        parkingExit.unParkVehicle(ticket);
        System.out.println(parkingExit.computeCost(ticket));

        parkingExit.unParkVehicle(ticket1);
        System.out.println(parkingExit.computeCost(ticket1));
    }

}
