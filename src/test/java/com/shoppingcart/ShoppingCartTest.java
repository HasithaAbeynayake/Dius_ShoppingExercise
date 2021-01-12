package com.shoppingcart;

import com.shoppingcart.handler.SpecialOffers;
import com.shoppingcart.model.Product;
import com.shoppingcart.service.CheckoutService;
import com.shoppingcart.service.StockService;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    private StockService service;
    private CheckoutService checkoutService;

    @Before
    public void setup() {
        service = new StockService();
    }

    /**
     * Happy path testing
     */

    @Test
    public void checkout3ATVand1VGA_shouldYieldPriceAs249() throws Exception {
        Map<Product, SpecialOffers> offers = service.getSpecialOffers();

        checkoutService = new CheckoutService(offers);
        checkoutService.checkout(Product.ATV);
        checkoutService.checkout(Product.ATV);
        checkoutService.checkout(Product.ATV);
        checkoutService.checkout(Product.VGA);

        double totalPrice = checkoutService.totalAmount();
        assertEquals(totalPrice, 249.00);
        System.out.println("Total Price: " + totalPrice);
    }

    @Test
    public void checkout1ATV2IPD1ATV3IPD_shouldYield2718_95() throws Exception {
        Map<Product, SpecialOffers> offers = service.getSpecialOffers();

        checkoutService = new CheckoutService(offers);
        checkoutService.checkout(Product.ATV);
        checkoutService.checkout(Product.IPD);
        checkoutService.checkout(Product.IPD);
        checkoutService.checkout(Product.ATV);
        checkoutService.checkout(Product.IPD);
        checkoutService.checkout(Product.IPD);
        checkoutService.checkout(Product.IPD);

        double totalPrice = checkoutService.totalAmount();
        assertEquals(totalPrice, 2718.95);
        System.out.println("Total Price: " + totalPrice);
    }

    @Test
    public void checkoutMBPVGAIPD_shouldYield1949_98() throws Exception {
        Map<Product, SpecialOffers> offers = service.getSpecialOffers();

        checkoutService = new CheckoutService(offers);
        checkoutService.checkout(Product.MBP);
        checkoutService.checkout(Product.VGA);
        checkoutService.checkout(Product.IPD);

        double totalPrice = checkoutService.totalAmount();
        assertEquals(totalPrice, 1949.98);
        System.out.println("Total Price: " + totalPrice);
    }

    /**
     * Alternate path testing
     */

    @Test(expected = Exception.class)
    public void nullValues_shouldYieldException() throws Exception {
        Map<Product, SpecialOffers> offers = service.getSpecialOffers();

        checkoutService = new CheckoutService(offers);
        checkoutService.checkout(null);
    }
}
