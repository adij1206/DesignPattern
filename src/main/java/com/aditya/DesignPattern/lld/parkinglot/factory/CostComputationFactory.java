package com.aditya.DesignPattern.lld.parkinglot.factory;

import com.aditya.DesignPattern.lld.parkinglot.CostComputation;
import com.aditya.DesignPattern.lld.parkinglot.FourWheelerCostComputation;
import com.aditya.DesignPattern.lld.parkinglot.TwoWheelerCostComputation;
import com.aditya.DesignPattern.lld.parkinglot.VehicleType;

public class CostComputationFactory {

    private TwoWheelerCostComputation twoWheelerCostComputation = null;
    private FourWheelerCostComputation fourWheelerCostComputation = null;

    public CostComputationFactory(
            TwoWheelerCostComputation twoWheelerCostComputation, FourWheelerCostComputation fourWheelerCostComputation
    ) {
        this.twoWheelerCostComputation = twoWheelerCostComputation;
        this.fourWheelerCostComputation = fourWheelerCostComputation;
    }

    public CostComputation getCostComputation(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> this.twoWheelerCostComputation;
            case FOUR_WHEELER -> this.fourWheelerCostComputation;
        };
    }
}
