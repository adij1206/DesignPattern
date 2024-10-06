package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import java.util.List;
import java.util.Queue;

public class OnlineStockBrokerage {

    private static OnlineStockBrokerage instance;
    private UserService userService;
    private AccountService accountService;
    private OrderService orderService;
    private StockService stockService;
    private PortfolioService portfolioService;
    private Queue<Order> orders;

    private OnlineStockBrokerage() {
        userService = new UserService();
        accountService = new AccountService();
        orderService = new OrderService();
        stockService = new StockService();
        portfolioService = new PortfolioService();
    }

    public synchronized static OnlineStockBrokerage getInstance() {
        if (instance == null) {
            instance = new OnlineStockBrokerage();
        }

        return instance;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void addAccount(Account account) {
        PortFolio portFolio = portfolioService.createPortfolio(account.getAccountId());
        account.setPortfolioId(portFolio.getPortfolioId());
        accountService.addAccount(account);
    }

    public Account getAccount(String accountId) {
        return accountService.getAccount(accountId);
    }

    public void updateAccountIdInUser(String userId, String accountId) {
        userService.setAccountNumber(userId, accountId);
    }

    public void addStock(Stock stock) {
        stockService.addStock(stock);
    }

    public List<Stock> getStockList() {
        return stockService.getStocks();
    }

    public void buyStock(String accountId, String stockId, int quantity) {
        Stock stock = stockService.getStock(stockId);

        if (stock == null || stock.getQuantity() < quantity) {
            System.out.println("We cannot add stock to the stock brokerage");
            return;
        }

        Account account = accountService.getAccount(accountId);
        if (account.getBalance() < quantity * stock.getPrice()) {
            System.out.println("We cannot add stock to the stock brokerage");
            return;
        }

        Order order = new Order(accountId, stockId, quantity, stock.getPrice());
        UserStock userStock = new UserStock(order.getStockId(), order.getQuantity(), stock.getPrice());
        portfolioService.addStock(userStock, order.getAccountId());
        orderService.addOrder(order);
        stockService.sellStockQuantity(order.getStockId(), quantity);
        accountService.withdraw(accountId, quantity * stock.getPrice());
        System.out.println("Purchased Successfully");
    }

    public void sellStock(String accountId, String stockId, int quantity) {
        Stock stock = stockService.getStock(stockId);
        Order order = new Order(accountId, stockId, quantity, stock.getPrice());
        orderService.addOrder(order);
        portfolioService.sellStock(accountId, stockId, quantity);
        accountService.deposit(accountId, quantity * stock.getPrice());
        stockService.addStockQuantity(stockId, quantity);
        System.out.println("Selled Successfully");
    }

    public PortFolio getPortfolio(String portfolioId) {
        return portfolioService.getPortfolio(portfolioId);
    }
}
