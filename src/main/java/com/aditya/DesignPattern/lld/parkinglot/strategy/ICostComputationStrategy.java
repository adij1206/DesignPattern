package com.aditya.DesignPattern.lld.parkinglot.strategy;

import com.aditya.DesignPattern.lld.parkinglot.Ticket;

import java.math.BigDecimal;

public interface ICostComputationStrategy {

    BigDecimal price(Ticket ticket);
}
