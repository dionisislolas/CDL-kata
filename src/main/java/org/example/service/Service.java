package org.example.service;

import org.example.entites.Item;

public interface Service {
    void addItem(Item item);

    void removeItem(Item item);

    Item findItemBySku(String sku);
}
