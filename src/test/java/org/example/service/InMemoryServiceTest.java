package org.example.service;

import org.example.entites.Item;
import org.example.exceptions.ItemNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InMemoryServiceTest {

    private static final String SKU_A = "A";
    private static final int PRICE_A = 50;

    private static final String SKU_B = "B";
    private static final int PRICE_B = 30;

    private InMemoryService service;
    private Item a, b;

    @Before
    public void setUp() throws Exception {
        service = new InMemoryService();
        a = new Item(SKU_A, PRICE_A);
        b = new Item(SKU_B, PRICE_B);
    }

    @Test
    public void testAddItem() {
        service.addItem(a);
        assertEquals(1, service.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItem_nullItem() {
        service.addItem(null);
    }

    @Test
    public void testRemoveItem() {
        service.addItem(a);
        service.addItem(b);
        service.removeItem(a);
        assertEquals(1, service.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItem_nullItem() {
        service.removeItem(null);
    }

    @Test
    public void testFindItemBySku() {
        service.addItem(a);
        assertEquals(a, service.findItemBySku(SKU_A));
    }

    @Test(expected = ItemNotFoundException.class)
    public void testFindItemBySku_ItemNotExist() {
        service.addItem(a);
        service.findItemBySku(SKU_B);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindItemBySku_nullItem() {
        service.findItemBySku(null);
    }
}