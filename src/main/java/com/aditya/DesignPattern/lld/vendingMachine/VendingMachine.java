package com.aditya.DesignPattern.lld.vendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private static VendingMachine instance;
    private ProductService productService;
    private InvoiceService invoiceService;
    private List<Product> products;
    private BigDecimal totalBill;

    private VendingMachine() {
        this.productService = new ProductService();
        this.invoiceService = new InvoiceService();
        products = new ArrayList<>();
        totalBill = BigDecimal.ZERO;
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            return new VendingMachine();
        }

        return instance;
    }

    public void addProductInMachine(Product products) {
        productService.addProduct(products);
    }

    public void displayProduct() {
        List<Product> products = productService.getAvailableProduct();

        for (Product product : products) {
            System.out.println(
                    "ProductName " + product.getId() + " Quantity " + product.getQuantity() + " Price " + product.getPrice());
        }
    }

    public void addProductInCart(String id, int quantity) {
        Product product = productService.getProduct(id);

        if (product == null) {
            System.out.println("We don't sell this product");
        }

        if (product.getQuantity() < quantity) {
            System.out.println("We don't have enough quantity to sell this product");
        }

        products.add(new Product(product.getId(), product.getPrice(), quantity));

        BigDecimal totalPrice = product.getPrice().multiply(new BigDecimal(quantity));
        totalBill = totalBill.add(totalPrice);

        System.out.println("Added product " + product.getId() + "totalPay :" + this.totalBill);
    }

    public void pay(List<Currency> currencies) {
        if (products.size() == 0) {
            System.out.println("No products selected");
            return;
        }

        for (Product product : products) {
            productService.updateQuantity(product.getId(), product.getQuantity());
        }

        invoiceService.pay(currencies);

        products = new ArrayList<>();
    }

}
