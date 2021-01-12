package com.shoppingcart.handler;

import com.shoppingcart.ShoppingCart;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.Stock;

import java.util.List;

public class FreeStockHandler implements SpecialOffers {

    private Product product;
    private Product freeProduct;

    public FreeStockHandler(Product product, Product freeProduct) {
        this.product = product;
        this.freeProduct = freeProduct;
    }

    public void applyOffer(ShoppingCart shoppingCart) {
        List<Stock> stocks = shoppingCart.getItemsBySKU(product);
        List<Stock> stocksFree = shoppingCart.getItemsBySKU(freeProduct);
        for (int i = 0; i < stocksFree.size(); i++) {
            if (i < stocks.size()) {
                Stock stock = stocksFree.get(i);
                stock.amendPrice(0);
            }
        }
    }
}
