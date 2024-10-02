package com.aditya.DesignPattern.lld.foodDeliverySystem;

import java.util.List;

public class FoodDeliverySystem {

    private static FoodDeliverySystem instance;

    private OrderService orderService;
    private CustomerService customerService;
    private RestaurantService restaurantService;
    private DeliveryAgentService deliveryAgentService;

    private FoodDeliverySystem() {
        orderService = new OrderService();
        customerService = new CustomerService();
        restaurantService = new RestaurantService();
        deliveryAgentService = new DeliveryAgentService();
    }

    public static FoodDeliverySystem getInstance() {
        if (instance == null) {
            instance = new FoodDeliverySystem();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    public void addDeliveryAgent(DeliveryAgent deliveryAgent) {
        deliveryAgentService.addDeliveryAgent(deliveryAgent);
    }

    public void addMenuItemInRestaurant(String restaurantId, MenuItem menuItem) {
        restaurantService.addMenuItemInRestaurant(restaurantId, menuItem);
    }

    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    public List<MenuItem> getAllMenuItemByRestaurantId(String restaurantId) {
        return restaurantService.getMenuItemByRestaurantId(restaurantId);
    }

    public Order placeOrder(String restaurantId, String customerId, List<OrderItem> orderItems) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);

        if (restaurant != null) {
            List<String> menuItemIds = orderItems.stream()
                    .map(OrderItem::getMenuItemId)
                    .toList();

            List<MenuItem> selectedMenuItem = restaurantService.getSelectedMenuItem(restaurantId, menuItemIds);

            double totalAmount = calculateTotalAmount(orderItems, selectedMenuItem);

            Order order = new Order(restaurantId, orderItems, totalAmount);
            orderService.addOrder(order);

            return order;
        }

        return null;
    }

    public void movetoConfirmState(String orderId) {
        Order orderById = orderService.getOrderById(orderId);
        if (orderById != null && OrderStatus.CREATED.name().equals(orderById.getStatus())) {
            orderById.setStatus(OrderStatus.CONFIRMED.name());
        }
    }

    public void moveToPreparingState(String orderId) {
        Order orderById = orderService.getOrderById(orderId);
        if (orderById != null && OrderStatus.CONFIRMED.name().equals(orderById.getStatus())) {
            orderById.setStatus(OrderStatus.PREPARING.name());
        }
    }

    public synchronized void assignDeliveryAgent(String orderId) {
        DeliveryAgent deliveryAgent = deliveryAgentService.getDeliveryAgent();

        if (deliveryAgent != null) {
            boolean assigned = orderService.assignDeliveryAgent(orderId, deliveryAgent.getId());
            if (!assigned) {
                System.out.println("Order is not prepared yet, once prepared we will assign delivery agent");
                return;
            }

            deliveryAgent.setAvailable(false);
            System.out.println("Delivery Agent Assigned, id " + deliveryAgent.getId());
        } else {
            System.out.println("No deliveryAgent found for orderId: " + orderId);
        }

    }

    public void moveToDeliveredState(String orderId) {
        Order orderById = orderService.getOrderById(orderId);
        if (orderById != null && OrderStatus.DELIVERY_AGENT_ASSIGNED.name().equals(orderById.getStatus())) {
            orderById.setStatus(OrderStatus.DELIVERED.name());

            deliveryAgentService.updateDeliveryAgentAvailability(orderById.getDeliveryAgentId(), true);
        }
    }

    public void moveToCancelledState(String orderId) {
        Order orderById = orderService.getOrderById(orderId);
        if (orderById != null &&
                (OrderStatus.CONFIRMED.name().equals(orderById.getStatus()) ||
                        OrderStatus.CREATED.name().equals(orderById.getStatus()))) {
            orderById.setStatus(OrderStatus.CANCELLED.name());
        }
    }

    private double calculateTotalAmount(List<OrderItem> orderItems, List<MenuItem> selectedMenuItem) {
        double totalAmount = 0.0;

        for (OrderItem orderItem : orderItems) {
            for (MenuItem menuItem : selectedMenuItem) {
                if (orderItem.getMenuItemId().equals(menuItem.getId())) {
                    totalAmount += orderItem.getQuantity() * menuItem.getPrice();
                }
            }
        }

        return totalAmount;
    }
}
