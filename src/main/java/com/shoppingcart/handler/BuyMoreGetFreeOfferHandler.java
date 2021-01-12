package com.shoppingcart.handler;

import com.shoppingcart.ShoppingCart;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.Stock;

import java.util.List;

public class BuyMoreGetFreeOfferHandler implements SpecialOffers {

    private Product product;
    private int totalQuantity;
    private int chargeableQuantity;

    public BuyMoreGetFreeOfferHandler(Product product, int totalQuantity, int chargeableQuantity) {
        this.product = product;
        this.totalQuantity = totalQuantity;
        this.chargeableQuantity = chargeableQuantity;
    }

    public void applyOffer(ShoppingCart shoppingCart) {
        List<Stock> stocks = shoppingCart.getItemsBySKU(product);
        for (int i = 0; i < stocks.size(); i++) {
            if (i + 1 == totalQuantity) {
                Stock stock = stocks.get(i);
                stock.amendPrice(0);
            }
        }
    }
}
