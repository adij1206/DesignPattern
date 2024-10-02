package com.aditya.DesignPattern.lld.oms;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class OrderManagementSystem {


    /*
        1. User to see the vehicle
        2. User can place an order for the vehicle
        3. Place the order only if he has money in the wallet
        4.
     */

    private OrderService orderService;
    private VehicleService vehicleService;
    private UserService userService;
    private WalletService walletService;

    public OrderManagementSystem(OrderService orderService, VehicleService vehicleService, UserService userService, WalletService walletService) {
        this.orderService = orderService;
        this.vehicleService = vehicleService;
        this.userService = userService;
        this.walletService = walletService;
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleService.getAllAvailableVehicle();
    }

//    public Order placeOrder(List<String> vehicleIds, String userId) {
//        boolean validateIfVehicleIsPresent = vehicleService.validateIfVehicleIsPresent(vehicleIds);
//
//        if (!validateIfVehicleIsPresent) {
//            throw new RuntimeException("Vehicle Not available");
//        }
//
//        double totalPrice = vehicleService.getTotalAmount(vehicleIds);
//
//        return orderService.createOrder(generateOrderID(), userId, vehicleIds, totalPrice);
//    }

    public Order placeOrderV2(List<String> vehicleIds, String userId) {
        CompletableFuture<Boolean> vehicleFuture = validateVehicle(vehicleIds);
        CompletableFuture<Boolean> userFuture = validateUser(userId);

        CompletableFuture.allOf(vehicleFuture, userFuture).join();

        double totalPrice = vehicleService.getTotalAmount(vehicleIds);

        return orderService.createOrder(generateOrderID(), userId, vehicleIds, totalPrice);
    }

    private CompletableFuture<Boolean> validateVehicle(List<String> vehicleIds) {

        return CompletableFuture.completedFuture(vehicleService.validateIfVehicleIsPresent(vehicleIds));
    }

    private CompletableFuture<Boolean> validateUser(String userId) {

        return CompletableFuture.completedFuture(userService.validateUser(userId));
    }

    private String generateOrderID() {
        return UUID.randomUUID().toString();
    }

    public void makePayment(String userId, String orderId) {
        User userByUserId = userService.getUserByUserId(userId);
        Wallet walletByWalletId = walletService.getWalletByWalletId(userByUserId.getWalletId());

        Order orderByOrderId = orderService.getOrderByOrderId(orderId);

        if (walletByWalletId.getAmount()<orderByOrderId.getTotalAmount()) {
            orderService.updateOrderStatus(orderId, OrderStatus.DELETED.name());
        }

        orderService.updateOrderStatus(orderId, OrderStatus.PAYMENT_SUBMITTED.name());
    }

    public static int getMaximumWaterStored(int[] height) {
        int n = height.length;

        int maximum = 0;

        for (int i=0;i<n;i++) {

            int leftMax = -1;
            for (int j=0;j<=i;j++) {
                if (height[j]>leftMax) {
                    leftMax = height[j];
                }
            }

            int rightMax = -1;
            for (int j = n-1;j>=i;j--) {
                if (height[j]>rightMax) {
                    rightMax = height[j];
                }
            }

            int sum = Math.min(leftMax, rightMax)-height[i];
            maximum+=sum;
        }

        return maximum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,0,3,2,5};


         System.out.println(getMaximumWaterStored(arr));
    }
}
