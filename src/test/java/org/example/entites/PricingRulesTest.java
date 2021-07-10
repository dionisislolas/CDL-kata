package org.example.entites;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PricingRulesTest {


    private PricingRules pricingRules;
    private SpecialOffer specialOffer;
    private String sku;

    @Before
    public void setUp() throws Exception {
        pricingRules = new PricingRules();
        sku = "A";
        specialOffer = new SpecialOffer(3, 130);
        pricingRules.addPricingRule(sku, specialOffer);
    }

    @Test
    public void testAddPricingRule() {
        assertEquals(1, pricingRules.getSize());
    }

    @Test
    public void testRemovePricingRule() {
        pricingRules.removePricingRule(sku);
        assertEquals(0, pricingRules.getSize());
    }

    @Test
    public void testGetSpecialOffer() {
        assertEquals(specialOffer, pricingRules.getSpecialOffer(sku));
    }
}