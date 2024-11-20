package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

@Data
public class ContactDetail {

    private String orderId;
    private String name;
    private String phoneNumber;

    public ContactDetail(String orderId, String name, String phoneNumber) {
        this.orderId = orderId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
