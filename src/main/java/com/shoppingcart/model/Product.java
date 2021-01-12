package com.shoppingcart.model;

public enum Product {
    IPD("ipd", "Super iPad"),
    MBP("mbp", "MacBook Pro"),
    ATV("atv", "Apple TV"),
    VGA("vga", "VGA Adapter");

    private String sku;
    private String name;

    Product(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public Product getSku() {
        return this.getSku();
    }

    public Product getName() {
        return this.getName();
    }
}
