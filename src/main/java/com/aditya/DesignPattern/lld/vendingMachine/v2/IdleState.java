package com.aditya.DesignPattern.lld.vendingMachine.v2;

public class IdleState implements State {

    public IdleState() {
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("Please press insert coin button!");
    }

    @Override
    public void selectProduct(VendingMachine machine, int code) {
        System.out.println("You are not allowed to select the product!");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int code) {
        System.out.println("You are not allowed to select the product!");
    }

    @Override
    public int returnChange(VendingMachine machine) {
        System.out.println("NO coin has been provided!");
        return 0;
    }

    @Override
    public int returnFullMoney(VendingMachine machine) {
        System.out.println("No amount present to be refunded!");
        return 0;
    }

    @Override
    public void clickOnInsertCoin(VendingMachine machine) {
        System.out.println("cliecked insert coin!");
        machine.setState(new HasMoneyState());
    }

    @Override
    public void clickOnSelectProduct(VendingMachine machine) {
        System.out.println("You are not allowed to select the product!");
    }

    @Override
    public int clickOnCancelProduct(VendingMachine machine) {
        System.out.println("You are not allowed to select the product!");
        return 0;
    }
}
