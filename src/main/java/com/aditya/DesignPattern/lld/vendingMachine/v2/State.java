package com.aditya.DesignPattern.lld.vendingMachine.v2;

public interface State {

    void insertCoin(VendingMachine machine, Coin coin);
    void selectProduct(VendingMachine machine, int code);
    void dispenseProduct(VendingMachine machine, int code);
    int returnChange(VendingMachine machine);
    int returnFullMoney(VendingMachine machine);
    void clickOnInsertCoin(VendingMachine machine);
    void clickOnSelectProduct(VendingMachine machine);
    int clickOnCancelProduct(VendingMachine machine);
}
