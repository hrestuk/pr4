package org.example;

public class OrderProcessor<T extends Product> {
    private T product;

    public OrderProcessor(T product) {
        this.product = product;
    }

    public void process() {
        System.out.println("Processing order for: " + product.getName() + " " +product.getDescription() + "Price: $" + product.getPrice());
    }

    public void startProcess()
    {
        Runnable orderTask = () -> System.out.println("Processing order in thread " + Thread.currentThread().getName());
        new Thread(orderTask).start();
    }

}
