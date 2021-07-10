package org.example.entites;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialOfferTest {

    private SpecialOffer specialOffer;

    @Before
    public void setUp() throws Exception {
        specialOffer = new SpecialOffer(3, 130);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetQuantityIllegal() {
        specialOffer.setQuantity(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetOfferPriceIllegal() {
        specialOffer.setOfferPrice(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testQuantityIllegal() {
        SpecialOffer specialOffer = new SpecialOffer(0, 150);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testOfferPriceIllegal() {
        SpecialOffer specialOffer = new SpecialOffer(3, 0);
    }

    @Test
    public void testToString() {
        assertFalse(specialOffer.toString().contains("@"));
    }

}