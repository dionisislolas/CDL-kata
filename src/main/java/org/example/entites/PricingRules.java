package org.example.entites;

import java.util.HashMap;
import java.util.Map;

public class PricingRules {

    // The String will represent the SKU
    private Map<String, SpecialOffer> pricingRulesMap = new HashMap<>();

    public PricingRules() {
    }

    public void addPricingRule(String sku, SpecialOffer specialOffer) {
        pricingRulesMap.put(sku, specialOffer);
    }

    public void removePricingRule(String sku) {
        pricingRulesMap.remove(sku);
    }

    public SpecialOffer getSpecialOffer(String sku) {
        return pricingRulesMap.get(sku);
    }

    // returns the number of entries in the map
    public int getSize() {
        return pricingRulesMap.size();
    }
}
