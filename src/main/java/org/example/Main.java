package org.example;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args)
    {
        Faker faker = new Faker();
        List<Product> products = new ArrayList<>();

        products.add(Clothing.builder()
                .name(faker.commerce().productName())
                .price(300.35)
                .description("Clothing")
                .build());

        products.add(Electronic.builder()
                .name(faker.commerce().productName())
                .price(2500.99)
                .description("Electronic")
                .build());


        //Clothing clothing =  Clothing.builder().name(faker.commerce().productName()).description(" Clothing ").price(200.25).build();
        //Electronic electronic =  Electronic.builder().name(faker.commerce().productName()).description(" Electronic ").price(1000.59).build();

        //OrderProcessor<Electronic> electronicOrder = new OrderProcessor<>(electronic);
        //OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(clothing);

        //clothingOrder.process();
        //clothingOrder.startProcess();

        //electronicOrder.process();
        //electronicOrder.startProcess();


        for (Product product : products) {
            OrderProcessor<Product> processor = new OrderProcessor<>(product);
            processor.process();
            processor.startProcess();
        }

        OrderStorage storage = new OrderStorage();

        products.forEach(storage::saveOrder);

        storage.getOrders().forEach(order ->
                System.out.println("Stored order: " + order.getName()));
    }
}