package com.aditya.DesignPattern.lld.foodDeliverySystem;

import java.util.Arrays;

/**
 * <p>The food delivery service should allow customers to browse restaurants, view menus, and place orders.</p>
 * <p> Restaurants should be able to manage their menus, prices, and availability.</p>
 * <p>Delivery agents should be able to accept and fulfill orders.</p>
 * <p>The system should handle order tracking and status updates.</p>
 * <p>The system should support multiple payment methods.</p>
 * <p>The system should handle concurrent orders and ensure data consistency.</p>
 * <p>The system should be scalable and handle a high volume of orders.</p>
 * <p>The system should provide real-time notifications to customers, restaurants, and delivery agents.</p>
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        // Create Restaurant
        Restaurant restaurant1 = new Restaurant("Restaurant1");
        Restaurant restaurant2 = new Restaurant("Restaurant2");

        // Create MenuItem
        MenuItem menuItem1 = new MenuItem("Dish1", "Dry Aloo", 100.0);
        MenuItem menuItem2 = new MenuItem("Dish2", "Kadhai Paneer", 210.0);
        MenuItem menuItem3 = new MenuItem("Dish3", "Paneer Butter Masala", 200.0);
        MenuItem menuItem4 = new MenuItem("Dish4", "French Fries", 100.0);
        MenuItem menuItem5 = new MenuItem("Dish5", "Masala Soda", 80.0);

        // Create DeliveryAgent
        DeliveryAgent deliveryAgent1 = new DeliveryAgent("DeliveryAgent1");
        DeliveryAgent deliveryAgent2 = new DeliveryAgent("DeliveryAgent2");

        // Create Customer
        Customer customer = new Customer("Aditya");

        FoodDeliverySystem deliverySystem = FoodDeliverySystem.getInstance();

        // Register Restaurant
        deliverySystem.addRestaurant(restaurant1);
        deliverySystem.addRestaurant(restaurant2);

        // Add Menu in Restaurant
        deliverySystem.addMenuItemInRestaurant(restaurant1.getId(), menuItem1);
        deliverySystem.addMenuItemInRestaurant(restaurant1.getId(), menuItem2);
        deliverySystem.addMenuItemInRestaurant(restaurant1.getId(), menuItem3);

        deliverySystem.addMenuItemInRestaurant(restaurant2.getId(), menuItem1);
        deliverySystem.addMenuItemInRestaurant(restaurant2.getId(), menuItem4);
        deliverySystem.addMenuItemInRestaurant(restaurant2.getId(), menuItem5);

        // register Delivery Agent
        deliverySystem.addDeliveryAgent(deliveryAgent1);
        deliverySystem.addDeliveryAgent(deliveryAgent2);

        // Register User
        deliverySystem.addCustomer(customer);


        System.out.println(deliverySystem.getAllRestaurant());
        System.out.println(deliverySystem.getAllMenuItemByRestaurantId(restaurant1.getId()));


        // Place Order 1
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                OrderItem orderItem1 = new OrderItem(menuItem1.getId(), 2);
                OrderItem orderItem2 = new OrderItem(menuItem2.getId(), 3);

                Order order = deliverySystem.placeOrder(
                        restaurant1.getId(), customer.getId(), Arrays.asList(orderItem1, orderItem2));

                deliverySystem.movetoConfirmState(order.getOrderId());
                deliverySystem.moveToPreparingState(order.getOrderId());
                deliverySystem.assignDeliveryAgent(order.getOrderId());
                deliverySystem.moveToDeliveredState(order.getOrderId());

            }
        });

        // Place Order 2
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                OrderItem orderItem3 = new OrderItem(menuItem1.getId(), 2);
                OrderItem orderItem4 = new OrderItem(menuItem4.getId(), 3);

                Order order2 = deliverySystem.placeOrder(
                        restaurant2.getId(), customer.getId(), Arrays.asList(orderItem3, orderItem4));

                deliverySystem.movetoConfirmState(order2.getOrderId());
                deliverySystem.moveToPreparingState(order2.getOrderId());
                deliverySystem.assignDeliveryAgent(order2.getOrderId());
            }
        });

        t1.start();
        thread.start();


        Thread.sleep(1000);

        // Place Order 3
        OrderItem orderItem5 = new OrderItem(menuItem1.getId(), 2);
        OrderItem orderItem6 = new OrderItem(menuItem5.getId(), 3);

        Order order3 = deliverySystem.placeOrder(
                restaurant2.getId(), customer.getId(), Arrays.asList(orderItem5, orderItem6));

        deliverySystem.movetoConfirmState(order3.getOrderId());
        deliverySystem.moveToPreparingState(order3.getOrderId());
        deliverySystem.assignDeliveryAgent(order3.getOrderId());
    }

}
