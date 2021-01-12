package com.shoppingcart.handler;

import com.shoppingcart.ShoppingCart;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.Stock;

import java.util.List;

public class BulkBuyingDiscountHandler implements SpecialOffers {

    private Product product;
    private int purchaseQty;
    private double discountedAmount;

    public BulkBuyingDiscountHandler(Product product, int purchaseQty, double discountedAmount) {
        this.product = product;
        this.purchaseQty = purchaseQty;
        this.discountedAmount = discountedAmount;
    }

    public void applyOffer(ShoppingCart shoppingCart) {
        List<Stock> stocks = shoppingCart.getItemsBySKU(product);
        if (stocks.size() > purchaseQty) {
            for (int i = 0; i < stocks.size(); i++) {
                Stock stock = stocks.get(i);
                stock.amendPrice(discountedAmount);
            }
        }
    }
}
