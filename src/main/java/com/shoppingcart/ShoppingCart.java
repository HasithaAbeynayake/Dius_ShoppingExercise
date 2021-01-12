package com.shoppingcart;

import com.shoppingcart.model.Product;
import com.shoppingcart.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Stock> stockList = new ArrayList();

    public ShoppingCart() {
    }

    public List<Stock> getItemsBySKU(Product product) {
        List<Stock> eligibleStocks = new ArrayList();
        for (Stock stock : this.stockList) {
            if (stock.getProduct().equals(product)) {
                eligibleStocks.add(stock);
            }
        }
        return eligibleStocks;
    }

    public double getTotalPrice() {
        double totalAmount = 0;
        for (Stock stock : this.stockList) {
            totalAmount = totalAmount + stock.getPrice();
        }
        return totalAmount;
    }

    public void addStocks(Stock stock) {
        stockList.add(stock);
    }
}