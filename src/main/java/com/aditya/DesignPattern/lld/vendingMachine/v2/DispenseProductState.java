package com.aditya.DesignPattern.lld.vendingMachine.v2;

public class DispenseProductState implements State{

    public DispenseProductState() {
    }

    @Override
    public void insertCoin(VendingMachine machine,Coin coin) {
        System.out.println("Not allowed to perform this action!");
    }

    @Override
    public void selectProduct(VendingMachine machine,int code) {
        System.out.println("Not allowed to perform this action!");
    }

    @Override
    public void dispenseProduct(VendingMachine machine,int code) {
        machine.dispenseProduct(code);
        machine.setState(new IdleState());
    }

    @Override
    public int returnChange(VendingMachine machine) {
        return machine.returnChange();
    }

    @Override
    public int returnFullMoney(VendingMachine machine) {
        return 0;
    }

    @Override
    public void clickOnInsertCoin(VendingMachine machine) {
        System.out.println("Not allowed to perform this action!");
    }

    @Override
    public void clickOnSelectProduct(VendingMachine machine) {
        System.out.println("Not allowed to perform this action!");
    }

    @Override
    public int clickOnCancelProduct(VendingMachine machine) {
        System.out.println("Not allowed to perform this action!");
        return 0;
    }
}
