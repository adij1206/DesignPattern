package com.aditya.DesignPattern.lld.foodDeliverySystem;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private Map<String , Customer> customers;

    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.put(customer.getId(), customer);
    }

    public Customer getCustomer(String id) {
        return this.customers.get(id);
    }
}
