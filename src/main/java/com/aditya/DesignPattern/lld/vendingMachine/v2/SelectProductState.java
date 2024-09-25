package com.aditya.DesignPattern.lld.vendingMachine.v2;

public class SelectProductState implements State {


    public SelectProductState() {
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("Already inserted coin!");
    }

    @Override
    public void selectProduct(VendingMachine machine, int code) {
        boolean b = machine.addProduct(code);

        if (!b) {
            System.out.println("Product not added to the machine!");
            machine.setState(new IdleState());
            return;
        }

        machine.setState(new DispenseProductState());
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int code) {
        System.out.println("Not allowed to perform this action!");
    }

    @Override
    public int returnChange(VendingMachine machine) {
        System.out.println("Not allowed to perform this action!");
        return 0;
    }

    @Override
    public int returnFullMoney(VendingMachine machine) {
        return machine.refundFullMoney();
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
        int returnFullMoney = returnFullMoney(machine);
        machine.setState(new IdleState());
        return returnFullMoney;
    }
}
