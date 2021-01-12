package com.shoppingcart.model;

public class Stock {
    private Product product;
    private double price;

    public Stock(Product product, double price) {
        this.product = product;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public void amendPrice(double newPrice) {
        this.price = newPrice;
    }
}