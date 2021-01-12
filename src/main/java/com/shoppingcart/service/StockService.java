package com.shoppingcart.service;

import com.shoppingcart.handler.BulkBuyingDiscountHandler;
import com.shoppingcart.handler.BuyMoreGetFreeOfferHandler;
import com.shoppingcart.handler.FreeStockHandler;
import com.shoppingcart.handler.SpecialOffers;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.Stock;

import java.util.HashMap;
import java.util.Map;

public class StockService {

    private Map<Product, SpecialOffers> specialOffers = new HashMap();
    private Map<Product, Stock> products = new HashMap();

    public StockService() {
        insertProduct(new Stock(Product.IPD, 549.99));
        insertProduct(new Stock(Product.MBP, 1399.99));
        insertProduct(new Stock(Product.ATV, 109.50));
        insertProduct(new Stock(Product.VGA, 30.00));

        addSpecialOffers(specialOffers);
    }

    public Stock insertStock(Product sku) {
        Stock stock = products.get(sku);
        return new Stock(stock.getProduct(), stock.getPrice());
    }

    public void insertProduct(Stock stock) {
        products.put(stock.getProduct(), stock);
    }

    public void addSpecialOffers(Map<Product, SpecialOffers> specialOffers) {
        specialOffers.put(Product.ATV, new BuyMoreGetFreeOfferHandler(Product.ATV, 3, 2));
        specialOffers.put(Product.IPD, new BulkBuyingDiscountHandler(Product.IPD, 4, 499.99));
        specialOffers.put(Product.VGA, new FreeStockHandler(Product.MBP, Product.VGA));
    }

    public Map<Product, SpecialOffers> getSpecialOffers() {
        return specialOffers;
    }
}