package com.aditya.DesignPattern.lld.onlineShoppingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {

    Map<String, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        this.products.put(product.getId(), product);
    }

    public Product getProductById(String productId) {
        return this.products.get(productId);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(this.products.values());
    }

    public List<Product> getSelectedProductByIds(List<String> productIds) {
        List<Product> selectedProducts = new ArrayList<>();

        for (Product product : this.products.values()) {
            if (productIds.contains(product.getId())) {
                selectedProducts.add(product);
            }
        }

        return selectedProducts;
    }

    public List<Product> searchProducts(String keyword) {
        return products.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void updateProductQuantity(String productId, int quantity) {
        Product product = this.products.get(productId);
        product.setQuantity(product.getQuantity()-quantity);
    }
}
