package org.example.validations;

import org.example.entites.Item;

public class Validate {

    public static void validateSku(String sku) {
        if (sku == null || sku.isEmpty()) {
            throw new IllegalArgumentException("Sku is required");
        }
    }

    public static void validatePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Illegal price: " + price);
        }
    }

    public static void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Illegal quantity: " + quantity);
        }
    }

    public static void validateOfferPrice(int offerPrice) {
        if (offerPrice <= 0) {
            throw new IllegalArgumentException("Illegal offer price: " + offerPrice);
        }
    }

    public static void validateItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is required");
        }
    }
}
