package com.aditya.DesignPattern.lld.digitalWalletSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentMethodService {

    private Map<String, PaymentMethod> paymentMethods;

    public PaymentMethodService() {
        this.paymentMethods = new HashMap<>();
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethods.put(paymentMethod.getId(), paymentMethod);
    }

    public PaymentMethod getPaymentMethod(String id) {
        return this.paymentMethods.get(id);
    }

    public List<PaymentMethod> getPaymentMethodOfUser(String userId) {
        List<PaymentMethod> paymentMethodsList = new ArrayList<>();

        for (PaymentMethod paymentMethod : paymentMethods.values()) {
            if (paymentMethod.getUserId().equals(userId)) {
                paymentMethodsList.add(paymentMethod);
            }
        }

        return paymentMethodsList;
    }

    public void removePaymentMethod(String id) {
        this.paymentMethods.remove(id);
    }
}
