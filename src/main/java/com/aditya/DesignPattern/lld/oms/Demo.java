package com.aditya.DesignPattern.lld.oms;

import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        //initialising the objects
        Wallet wallet1 = new Wallet("1234", 1000.0);
        WalletService walletService = new WalletService();
        walletService.addWallet(wallet1);

        User user = new User("123", "Aditya", wallet1.getWalletId());
        UserService userService = new UserService();
        userService.addUser(user);

        Vehicle vehicle1 = new Vehicle("1234567", "Honda", 150.0);
        Vehicle vehicle2 = new Vehicle("123489", "Acura", 1000.0);
        VehicleService vehicleService = new VehicleService();
        vehicleService.addVehicle(vehicle1);
        vehicleService.addVehicle(vehicle2);

        OrderService orderService = new OrderService();

        OrderManagementSystem orderManagementSystem = new OrderManagementSystem(
                orderService,
                vehicleService,
                userService,
                walletService
        );

        List<Vehicle> allVehicle = orderManagementSystem.getAllVehicle();
        System.out.println(allVehicle);

        Order order = null;
        try {
            order = orderManagementSystem.placeOrderV2(Arrays.asList("1234567"), "123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        orderManagementSystem.makePayment("123", order.getOrderId());

    }
}
