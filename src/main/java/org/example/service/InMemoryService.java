package org.example.service;

import org.example.entites.Item;
import org.example.exceptions.ItemNotFoundException;

import java.util.HashMap;
import java.util.Map;

import static org.example.validations.Validate.validateItem;
import static org.example.validations.Validate.validateSku;

public class InMemoryService implements Service {
    private Map<String, Item> data = new HashMap<>();

    @Override
    public void addItem(Item item) {
        validateItem(item);
        data.put(item.getSku(), item);
    }

    @Override
    public void removeItem(Item item) {
        validateItem(item);
        data.remove(item.getSku());
    }

    @Override
    public Item findItemBySku(String sku) {
        validateSku(sku);
        Item item = data.get(sku);
        if (item == null) {
            throw new ItemNotFoundException(sku);
        }
        return item;
    }

    public int getSize() {
        return data.size();
    }
}
