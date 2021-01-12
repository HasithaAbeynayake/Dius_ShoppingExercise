package com.shoppingcart.service;

import com.shoppingcart.ShoppingCart;
import com.shoppingcart.handler.SpecialOffers;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.Stock;

import java.util.Map;

public class CheckoutService {
    private ShoppingCart shoppingCart = new ShoppingCart();
    private StockService service = new StockService();
    private Map<Product, SpecialOffers> offers;

    public CheckoutService(Map<Product, SpecialOffers> offers) {
        this.offers = offers;
    }

    public void checkout(Product product) throws Exception {
        if (product == null) {
            throw new Exception("Invalid Product! Please check the Stocks!!!");
        }
        Stock stock = service.insertStock(product);
        shoppingCart.addStocks(stock);
        SpecialOffers offer = offers.get(product);
        if (offer != null) {
            offer.applyOffer(shoppingCart);
        }
    }

    public double totalAmount() {
        return shoppingCart.getTotalPrice();
    }
}