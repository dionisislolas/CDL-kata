package org.example.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String sku) {
        super("Item with sku=" + sku + " not found");
    }
}
