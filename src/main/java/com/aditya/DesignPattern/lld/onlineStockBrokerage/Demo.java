package com.aditya.DesignPattern.lld.onlineStockBrokerage;

public class Demo {

    public static void main(String[] args) {
        //Create User
        User user = new User("123", "Aditya");

        // Create Account
        Account account = new Account(user.getId(), 1000);

        // Create Stock
        Stock stock1 = new Stock(100, 20);
        Stock stock2 = new Stock(200, 40);
        Stock stock3 = new Stock(300, 60);
        Stock stock4 = new Stock(400, 80);

        // Create OnlineBrokerage System
        OnlineStockBrokerage stockBrokerage = OnlineStockBrokerage.getInstance();

        stockBrokerage.addStock(stock1);
        stockBrokerage.addStock(stock2);
        stockBrokerage.addStock(stock3);
        stockBrokerage.addStock(stock4);

        stockBrokerage.addUser(user);
        stockBrokerage.addAccount(account);
        stockBrokerage.updateAccountIdInUser(user.getId(), account.getAccountId());

        //        System.out.println(stockBrokerage.getStockList());
        //        System.out.println(stockBrokerage.getAccount(account.getAccountId()));
        //        System.out.println(stockBrokerage.getPortfolio(account.getAccountId()));

        // Buy Stock
        stockBrokerage.buyStock(account.getAccountId(), stock1.getId(), 20);
        //        System.out.println(stockBrokerage.getPortfolio(account.getAccountId()));
        stockBrokerage.buyStock(account.getAccountId(), stock2.getId(), 3);
        System.out.println(stockBrokerage.getPortfolio(account.getAccountId()));
        stockBrokerage.buyStock(account.getAccountId(), stock1.getId(), 20);
        //        System.out.println(stockBrokerage.getPortfolio(account.getAccountId()));

        //        System.out.println(stockBrokerage.getStockList());
        //        System.out.println(stockBrokerage.getAccount(account.getAccountId()));

        stockBrokerage.sellStock(account.getAccountId(), stock1.getId(), 30);
        //        System.out.println(stockBrokerage.getPortfolio(account.getAccountId()));

        //        System.out.println(stockBrokerage.getStockList());
        //        System.out.println(stockBrokerage.getAccount(account.getAccountId()));
    }
}
