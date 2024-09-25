package com.aditya.DesignPattern.lld.vendingMachine.v2;

public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        initialSetUp(vendingMachine);

        State state = vendingMachine.getState();
        state.clickOnInsertCoin(vendingMachine);

        Coin coin = new Coin(100);
        Coin coin1 = new Coin(50);
        Coin coin2 = new Coin(50);

        state = vendingMachine.getState();
        state.insertCoin(vendingMachine, coin1);
        state.insertCoin(vendingMachine, coin2);
        state.insertCoin(vendingMachine, coin);

        //System.out.println(state.clickOnCancelProduct(vendingMachine));

        state = vendingMachine.getState();
        state.clickOnSelectProduct(vendingMachine);

        //System.out.println(state.clickOnCancelProduct(vendingMachine));

        state = vendingMachine.getState();
        state.selectProduct(vendingMachine, 100);

        //System.out.println(state.clickOnCancelProduct(vendingMachine));

        state = vendingMachine.getState();
        int val = state.returnChange(vendingMachine);
        System.out.println("Returns" + val);
        state.dispenseProduct(vendingMachine, 100);

    }

    private static void initialSetUp(VendingMachine vendingMachine) {
        Product product1 = new Product(100, 100, 5);
        Product product2 = new Product(101, 200, 5);
        Product product3 = new Product(102, 300, 5);
        Product product4 = new Product(103, 400, 5);
        Product product5 = new Product(104, 500, 5);

        vendingMachine.insertProduct(product1);
        vendingMachine.insertProduct(product2);
        vendingMachine.insertProduct(product3);
        vendingMachine.insertProduct(product4);
        vendingMachine.insertProduct(product5);
    }
}
