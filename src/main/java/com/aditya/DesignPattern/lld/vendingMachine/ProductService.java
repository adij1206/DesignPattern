package com.aditya.DesignPattern.lld.vendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {
                products.remove(i);
                break;
            }
        }
    }

    public void updateQuantity(String productId, int quantity) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                product.subtractQuantity(quantity);
            }
        }
    }

    public Product getProduct(String productId) {
        return products.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    public BigDecimal getProductPrice(String productId) {
        return products.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .map(Product::getPrice)
                .orElse(BigDecimal.ZERO);
    }

    public List<Product> getAvailableProduct() {
        return products.stream()
                .filter(product -> product.getQuantity() > 0)
                .collect(Collectors.toList());
    }
}
