package com.aditya.DesignPattern.lld.onlineShoppingSystem;

public class Demo {

    public static void main(String[] args) {
        // Creating User
        User user = new User("123", "Aditya");
        User user2 = new User("124", "Aditya");

        // Creating Product
        Product product1 = new Product("Icecream", "Icecream with vanilla flavour", 20.0, 5);
        Product product2 = new Product("Chocolate", "DarkChocolate", 40.0, 25);
        Product product3 = new Product("Cookies", "Baked cookies", 10.0, 15);
        Product product4 = new Product("Pepsi", "ColdDrink", 25.0, 7);
        Product product5 = new Product("Milk", "Cow Milk", 27.0, 10);

        OnlineShoppingSystem shoppingSystem = OnlineShoppingSystem.getInstance();
        shoppingSystem.addProduct(product1);
        shoppingSystem.addProduct(product2);
        shoppingSystem.addProduct(product3);
        shoppingSystem.addProduct(product4);
        shoppingSystem.addProduct(product5);

        shoppingSystem.addUser(user);
        shoppingSystem.addUser(user2);

        System.out.println(shoppingSystem.getAllProducts());

        // Create Cart and add item in it
        shoppingSystem.addItemInTheCart(product1.getId(), 4, user.getUserId());
        shoppingSystem.addItemInTheCart(product3.getId(), 7, user.getUserId());
        shoppingSystem.addItemInTheCart(product4.getId(), 5, user.getUserId());

        shoppingSystem.removeProductFromCart(product4.getId(), 3, user.getUserId());

        Order order = shoppingSystem.placeOrder(user.getUserId());
        System.out.println(order);

        shoppingSystem.updateOrder(order.getOrderId(), OrderStatus.CONFIRMED);

        shoppingSystem.updateOrder(order.getOrderId(), OrderStatus.PAYMENT_SUBMITTED);


        shoppingSystem.addItemInTheCart(product1.getId(), 1, user.getUserId());
        shoppingSystem.addItemInTheCart(product3.getId(), 7, user.getUserId());
        shoppingSystem.addItemInTheCart(product4.getId(), 2, user.getUserId());

        shoppingSystem.addItemInTheCart(product1.getId(), 1, user2.getUserId());

        Order order1 = shoppingSystem.placeOrder(user.getUserId());
        System.out.println(order1);

        Order order2 = shoppingSystem.placeOrder(user2.getUserId());
        System.out.println(order2);
    }
}
