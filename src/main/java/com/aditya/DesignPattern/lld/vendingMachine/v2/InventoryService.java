package com.aditya.DesignPattern.lld.vendingMachine.v2;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {

    List<Product> products;

    public InventoryService() {
        this.products = new ArrayList<>();
    }

    public Product getProductById(int code) {
        return products.stream()
                .filter(p -> code == p.getCode())
                .findFirst()
                .orElse(null);
    }

    public void updateQuantity(int code) {
        for (Product product : products) {
            if (code == product.getCode() && product.getQuantity()>0) {
                product.setQuantity(product.getQuantity() - 1);
            }
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
