package org.example.entites;

import org.example.service.InMemoryService;
import org.example.service.Service;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutTest {

    private static final String SKU_A = "A";
    private static final int PRICE_A = 50;

    private static final String SKU_B = "B";
    private static final int PRICE_B = 30;

    private Checkout checkout;

    @Before
    public void setUp() throws Exception {
        PricingRules pricingRules = new PricingRules();
        SpecialOffer offer1 = new SpecialOffer(3, 130);
        SpecialOffer offer2 = new SpecialOffer(2, 45);
        pricingRules.addPricingRule(SKU_A, offer1);
        pricingRules.addPricingRule(SKU_B, offer2);
        Service service = new InMemoryService();
        Item a = new Item(SKU_A, PRICE_A);
        Item b = new Item(SKU_B, PRICE_B);
        service.addItem(a);
        service.addItem(b);

        checkout = new Checkout(pricingRules, service);
    }

    @Test
    public void testAddItem() {
        checkout.addItem(SKU_A);
        checkout.addItem(SKU_B);
        assertEquals(2, checkout.getSize());
    }

    @Test
    public void removeItem() {
        checkout.addItem(SKU_A);
        checkout.addItem(SKU_A);
        checkout.addItem(SKU_B);
        checkout.removeItem(SKU_A);
        assertEquals(2, checkout.getSize());
    }

    @Test
    public void runningTotal() {
        checkout.addItem(SKU_A);
        checkout.addItem(SKU_B);
        assertEquals(80, checkout.runningTotal());
    }

    @Test
    public void testRunningTotal_multiPricedItem() {
        checkout.addItem(SKU_A);
        checkout.addItem(SKU_B);
        checkout.addItem(SKU_B);
        assertEquals(95, checkout.runningTotal());
    }

    @Test
    public void testRunningTotal_multiPricedItem_moreItems() {
        checkout.addItem(SKU_A);
        checkout.addItem(SKU_B);
        checkout.addItem(SKU_B);
        checkout.addItem(SKU_A);
        checkout.addItem(SKU_B);
        checkout.addItem(SKU_B);
        checkout.addItem(SKU_B);
        checkout.addItem(SKU_A);
        assertEquals(250, checkout.runningTotal());
    }
}