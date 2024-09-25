package com.aditya.DesignPattern.lld.vendingMachine.v2;

public class HasMoneyState implements State {


    public HasMoneyState() {
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        machine.addCoin(coin);
    }

    @Override
    public void selectProduct(VendingMachine machine, int code) {
        System.out.println("You are not allowed to select the product!");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int code) {
        System.out.println("System is not allowed to dispense the product!");
    }

    @Override
    public int returnChange(VendingMachine machine) {
        System.out.println("No product has been selected, so either we can refund the full fund!");
        returnFullMoney(machine);
        return 0;
    }

    @Override
    public int returnFullMoney(VendingMachine machine) {
        return machine.refundFullMoney();
    }

    @Override
    public void clickOnInsertCoin(VendingMachine machine) {
        System.out.println("Already Pressed!");
    }

    @Override
    public void clickOnSelectProduct(VendingMachine machine) {
        machine.setState(new SelectProductState());
    }

    @Override
    public int clickOnCancelProduct(VendingMachine machine) {
        int returnFullMoney = returnFullMoney(machine);
        machine.setState(new IdleState());
        return returnFullMoney;
    }
}
