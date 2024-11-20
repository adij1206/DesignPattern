package com.aditya.DesignPattern.lld.restaurantSystem;

import java.util.List;

public class RestaurantSystem {

    private OrderService orderService;
    private MenuService menuService;
    private PaymentService paymentService;
    private RestaurantService restaurantService;
    private TableService tableService;

    public RestaurantSystem() {
        orderService = new OrderService();
        menuService = new MenuService();
        paymentService = new PaymentService();
        restaurantService = new RestaurantService();
        tableService = new TableService();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    public Restaurant getRestaurantById(String id) {
        return restaurantService.getRestaurantById(id);
    }

    public void addTable(Table table) {
        tableService.addTable(table);
    }

    public Table getTable(String restaurantId, String tableNumber) {
        return tableService.getTable(restaurantId, tableNumber);
    }

    public List<Table> getAvailableTables(String restaurantId) {
        return tableService.getAvailableTables(restaurantId);
    }

    public void addMenu(Menu menu) {
        menuService.addMenu(menu);
    }

    public Menu getMenu(String restaurantId) {
        return menuService.getMenu(restaurantId);
    }

    public void addMenuItem(MenuItem menuItem) {
        menuService.addMenuItem(menuItem);
    }

    public List<MenuItem> getAvailableMenuItem(String menuId) {
        return menuService.getAvailableMenuItem(menuId);
    }

    public List<AddOnItem> getAvailableAddOnItem(String menuItemId) {
        return menuService.getAvailableAddOnItem(menuItemId);
    }

    public void addAddOnItem(AddOnItem addOnItem) {
        menuService.addAddOnItem(addOnItem);
    }

    public Order createOrder(String restaurantId, String tableNumber) {
        Order order = new Order(restaurantId, tableNumber, OrderStatus.PENDING.name());
        orderService.addOrder(order);

        tableService.assignOrderId(restaurantId, tableNumber, order.getOrderId());
        return order;
    }

    public Order getOrder(String orderId) {
        return orderService.getOrder(orderId);
    }

    public void addOrderItem(OrderItem orderItem) {
        MenuItem menuItem = menuService.getMenuItem(orderItem.getMenuItemId());

        if (!menuItem.getAvailable()) {
            System.out.println("Item is not available currently");
            return;
        }

        orderService.addOrderItem(orderItem);
    }

    public OrderItem getOrderItem(String orderItemId) {
        return orderService.getOrderItem(orderItemId);
    }

    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        return orderService.getOrderItemsByOrderId(orderId);
    }

    public void updateServedStatusOdOrderItem(String orderItemId, Boolean isServed) {
        orderService.updateServedStatusOdOrderItem(orderItemId, isServed);
    }

    public void addAddOnItemIds(String orderItemId, List<String> addOnItemIds) {
        orderService.addAddOnItemIds(orderItemId, addOnItemIds);
    }

    public void updatePreparingStatusOfOrder(String orderId) {
        orderService.updateOrderStatus(orderId, OrderStatus.PREPARING);
    }

    public String generateBill(String orderId, String restaurantId) {
        List<OrderItem> orderItemList = orderService.getOrderItemsByOrderId(orderId);

        Double totalPrice = 0.0;
        Menu menu = menuService.getMenu(restaurantId);

        List<MenuItem> menuItems = menuService.getMenuItemsByMenuId(menu.getId());

        for (MenuItem menuItem : menuItems) {
            for (OrderItem orderItem : orderItemList) {
                if (orderItem.getMenuItemId().equals(menuItem.getId())) {
                    totalPrice += menuItem.getPrice();

                    List<AddOnItem> addOnItemList = menuService.getAddOnItem(menuItem.getId());
                    List<String> addonItemIdList = orderItem.getAddOnItemIds();

                    for (AddOnItem addOnItem : addOnItemList) {
                        if (addonItemIdList.contains(addOnItem.getId())) {
                            totalPrice += addOnItem.getPrice();
                        }
                    }
                }
            }
        }

        orderService.updateTotalPrice(orderId, totalPrice);

        Payment payment = new Payment(orderId, totalPrice, PaymentStatus.PENDING.name());
        paymentService.addPayment(payment);

        return payment.getId();
    }

    public void makePayment(String paymentId, PaymentMode paymentMode, String orderId) {
        PaymentModeService paymentModeService;
        switch (paymentMode) {
            case CARD:
                paymentModeService = new CardPayment(paymentService);
                paymentModeService.processPayment(paymentId);
                return;
            case CASH:
                paymentModeService = new CashPayment(paymentService);
                paymentModeService.processPayment(paymentId);
                return;
            case UPI:
                paymentModeService = new UpiPayment(paymentService);
                paymentModeService.processPayment(paymentId);
                return;
        }

        orderService.updateOrderStatus(orderId, OrderStatus.PAYMENT_DONE);
    }

    public void updateMenuItemAvailability(String menuItemID, boolean availability) {
        menuService.updateMenuItemAvailability(menuItemID, availability);
    }

    public void updateAddOnItemAvailability(String addOnsId, boolean availability) {
        menuService.updateAddOnItemAvailability(addOnsId, availability);
    }

}


