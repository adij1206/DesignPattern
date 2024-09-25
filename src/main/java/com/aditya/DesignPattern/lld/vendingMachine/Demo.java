package com.aditya.DesignPattern.lld.vendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Product product1 = new Product("Abc", new BigDecimal(100), 5);
        Product product2 = new Product("Abd", new BigDecimal(200), 5);
        Product product3 = new Product("Abe", new BigDecimal(300), 5);
        Product product4 = new Product("Abf", new BigDecimal(400), 5);

        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.addProductInMachine(product1);
        vendingMachine.addProductInMachine(product2);
        vendingMachine.addProductInMachine(product3);
        vendingMachine.addProductInMachine(product4);

        vendingMachine.displayProduct();

        System.out.println("Add Product");
        Scanner scanner =  new Scanner(System.in);

        // Taking products input
        while (true) {
            System.out.println("Enter Product ID (or type 'done' to finish): ");
            String productId = scanner.nextLine();

            // Check for break condition
            if (productId.equalsIgnoreCase("done")) {
                break;  // Exit the loop when 'done' is entered
            }

            System.out.println("Enter Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            vendingMachine.addProductInCart(productId, quantity);
        }

        System.out.println("Please Pay");

        List<Currency> currencyList = new ArrayList<>();

        // Taking currency input
        while (true) {
            System.out.println("Enter Amount (or enter 0 to finish): ");
            int amount = Integer.parseInt(scanner.nextLine());

            // Check for break condition
            if (amount == 0) {
                break;  // Exit the loop when 0 is entered
            }

            Currency currency = new Currency(amount);
            currencyList.add(currency);
        }

        vendingMachine.pay(currencyList);
    }
}
