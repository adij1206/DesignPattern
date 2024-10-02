package com.aditya.DesignPattern.lld.oms;

import java.util.List;

public class Order {

    private String orderId;
    private List<String> vehicleIds;
    private String userId;
    private double totalAmount;
    private String status;

    public Order(String orderId, List<String> vehicleIds, String userId, double totalAmount) {
        this.orderId = orderId;
        this.vehicleIds = vehicleIds;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = OrderStatus.CREATED.name();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<String> getVehicleIds() {
        return vehicleIds;
    }

    public void setVehicleIds(List<String> vehicleIds) {
        this.vehicleIds = vehicleIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }
}

