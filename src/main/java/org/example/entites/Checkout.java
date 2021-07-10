package org.example.entites;

import org.example.service.InMemoryService;
import org.example.service.Service;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Map<String, Integer> items = new HashMap<>();
    private PricingRules pricingRules;
    private Service service;
    private int runningTotal;

    public Checkout(PricingRules pricingRules, Service service) {
        this.pricingRules = pricingRules;
        this.service = service;
    }

    public void addItem(String sku) {
        items.merge(sku, 1, (v1, v2)->v1 + v2);
    }

    public void removeItem(String sku) {
        items.merge(sku, 1, (v1, v2)->v1 - v2);
    }

    public int runningTotal() {
        runningTotal = 0;
        items.forEach((sku, quantity)-> {
            Item item = service.findItemBySku(sku);
            SpecialOffer specialOffer = pricingRules.getSpecialOffer(sku);
            if (quantity >= specialOffer.getQuantity()) {
                int quotient = quantity / specialOffer.getQuantity();
                int remainder = quantity % specialOffer.getQuantity();
                runningTotal = runningTotal + specialOffer.getOfferPrice() * quotient;

                for (int i=0; i<remainder; i++) {
                    runningTotal += item.getPrice();
                }

            } else {
                for (int i=0; i<quantity; i++) {
                    runningTotal += item.getPrice();
                }
            }
        });
        return runningTotal;
    }

    public int getSize() {
        return items.size();
    }
}
