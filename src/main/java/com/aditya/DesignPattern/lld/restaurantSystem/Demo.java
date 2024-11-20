package com.aditya.DesignPattern.lld.restaurantSystem;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Udupi", "Bangalore");

        Menu menu = new Menu(restaurant.getId());

        MenuItem menuItem1 = new MenuItem(menu.getId(), "Tea", "Normal Tea", 10.0);
        MenuItem menuItem2 = new MenuItem(menu.getId(), "Cheese Pizza", "Contains Cheese", 100.0);
        MenuItem menuItem3 = new MenuItem(menu.getId(), "Red Pasta", "Pasta with red sauce", 120.0);
        MenuItem menuItem4 = new MenuItem(menu.getId(), "Coffee", "Normal Coffee", 25.0);

        AddOnItem addOnItem1 = new AddOnItem("Extra Cheese", 25.0, menuItem2.getId());
        AddOnItem addOnItem2 = new AddOnItem("Tomato Topping", 15.0, menuItem2.getId());
        AddOnItem addOnItem3 = new AddOnItem("Oregano", 22.0, menuItem3.getId());
        AddOnItem addOnItem4 = new AddOnItem("Extra Myonese", 21.0, menuItem3.getId());

        Table table1 = new Table("101", restaurant.getId());
        Table table2 = new Table("102", restaurant.getId());
        Table table3 = new Table("103", restaurant.getId());

        RestaurantSystem restaurantSystem = new RestaurantSystem();

        restaurantSystem.addRestaurant(restaurant);
        restaurantSystem.addMenu(menu);

        restaurantSystem.addMenuItem(menuItem1);
        restaurantSystem.addMenuItem(menuItem2);
        restaurantSystem.addMenuItem(menuItem3);
        restaurantSystem.addMenuItem(menuItem4);

        restaurantSystem.addAddOnItem(addOnItem1);
        restaurantSystem.addAddOnItem(addOnItem2);
        restaurantSystem.addAddOnItem(addOnItem3);
        restaurantSystem.addAddOnItem(addOnItem4);

        restaurantSystem.addTable(table1);
        restaurantSystem.addTable(table2);
        restaurantSystem.addTable(table3);


        System.out.println("Restaurant" + restaurantSystem.getRestaurantById(restaurant.getId()));

        System.out.println("Available Table " + restaurantSystem.getAvailableTables(restaurant.getId()));

        System.out.println("MenuItems " + restaurantSystem.getAvailableMenuItem(menu.getId()));

        System.out.println("Creating Order");
        Order order = restaurantSystem.createOrder(restaurant.getId(), "101");
        System.out.println("Order " + order);

        OrderItem orderItem1 = new OrderItem(order.getOrderId(), menuItem1.getId());
        OrderItem orderItem2 = new OrderItem(order.getOrderId(), menuItem2.getId());

        restaurantSystem.addOrderItem(orderItem1);
        restaurantSystem.addOrderItem(orderItem2);
        restaurantSystem.addAddOnItemIds(orderItem2.getId(), Arrays.asList(addOnItem1.getId()));

        restaurantSystem.updateMenuItemAvailability(menuItem2.getId(), false);


        System.out.println("Creating Order");
        Order order2 = restaurantSystem.createOrder(restaurant.getId(), "102");
        System.out.println("Order " + order2);

        OrderItem orderItem3 = new OrderItem(order.getOrderId(), menuItem2.getId());

        restaurantSystem.addOrderItem(orderItem3);

        System.out.println("Available Table " + restaurantSystem.getAvailableTables(restaurant.getId()));
    }
}
