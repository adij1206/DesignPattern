package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class OnlineShoppingSystem {

    private static OnlineShoppingSystem instance;
    private OrderService orderService;
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private ProductService productService;

    private OnlineShoppingSystem() {
        orderService = new OrderService();
        userService = new UserService();
        shoppingCartService = new ShoppingCartService();
        productService = new ProductService();
    }

    public static synchronized OnlineShoppingSystem getInstance() {
        if (instance == null) {
            instance = new OnlineShoppingSystem();
        }

        return instance;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public User getUser(String userId) {
        return userService.getUSerById(userId);
    }

    public Product getProductById(String productId) {
        return productService.getProductById(productId);
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public void addItemInTheCart(String productId, int quantity, String userId) {
        Product product = productService.getProductById(productId);

        if (product == null || product.getQuantity() < quantity) {
            System.out.println("Currently Product is not available!");
            return;
        }

        OrderItem orderItem = createOrderItem(productId, quantity);
        double price = calculatePrice(product, quantity);

        shoppingCartService.addItemInCart(userId, orderItem, price);
        System.out.println("Item Added in the cart!");
    }

    public void removeProductFromCart(String productId, int quantity, String userId) {
        shoppingCartService.removeItemFromCart(userId, productId, quantity);
        System.out.println("Item Removed from cart!");
    }

    public double getTotalPriceOfCart(String userId) {
        return shoppingCartService.getTotalPriceOfCart(userId);
    }

    public synchronized Order placeOrder(String userId) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);

        List<OrderItem> allOrderItem = shoppingCart.getAllOrderItem();
        List<String> productIds = allOrderItem.stream().map(OrderItem::getProductId).toList();
        List<Product> selectedProductByIds = productService.getSelectedProductByIds(productIds);

        List<OrderItem> orderItems = new ArrayList<>();
        double totalPrice = 0;
        for (OrderItem orderItem : allOrderItem) {
            for (Product product : selectedProductByIds) {
                if (orderItem.getProductId().equals(product.getId()) &&
                        orderItem.getQuantity() < product.getQuantity()) {
                    productService.updateProductQuantity(product.getId(), orderItem.getQuantity());
                    orderItems.add(orderItem);
                    totalPrice += product.getPrice() * orderItem.getQuantity();
                }
            }
        }

        Order order = new Order(userId, orderItems, totalPrice);
        orderService.addOrder(order);
        shoppingCartService.removeShoppingCart(userId);
        return order;
    }

    public void updateOrder(String orderId, OrderStatus orderStatus) {
        orderService.updateStatus(orderId, orderStatus);
        System.out.println("Order Status Updated");
    }

    private double calculatePrice(Product product, int quantity) {
        return quantity * product.getPrice();
    }

    private OrderItem createOrderItem(String productId, int quantity) {
        return new OrderItem(productId, quantity);
    }
}
