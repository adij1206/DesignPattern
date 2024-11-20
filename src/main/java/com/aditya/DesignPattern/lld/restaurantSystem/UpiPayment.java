package com.aditya.DesignPattern.lld.restaurantSystem;

public class UpiPayment implements PaymentModeService{
    private PaymentService paymentService;

    public UpiPayment(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void processPayment(String paymentId) {
        paymentService.updateStatusAndModeOfPayment(paymentId, PaymentStatus.SUCCESS, PaymentMode.UPI.name());
    }
}
