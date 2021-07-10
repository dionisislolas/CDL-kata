package org.example.entites;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    private Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item("A", 50);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetSkuIllegal_NullProvided() {
        item.setSku(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetSkuIllegal_EmptyStringProvided() {
        item.setSku("");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSkuIllegal_NullProvided() {
        Item item = new Item(null, 50);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSkuIllegal_EmptyStringProvided() {
        Item item = new Item("", 50);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetPriceIllegal() {
        item.setPrice(0);
    }

    @Test
    public void testToString() {
        assertFalse(item.toString().contains("@"));
    }
}