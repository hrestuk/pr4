package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {
    private final List<Product> orders = new ArrayList<>();

    public void saveOrder(Product product) {
        orders.add(product);
        System.out.println("Order saved: " + product.getName());
    }

    public List<Product> getOrders() {
        return orders;
    }
}
