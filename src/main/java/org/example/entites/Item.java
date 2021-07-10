package org.example.entites;

public class Item {
    private String sku;
    private int price;

    public Item() {
    }

    public Item(String sku, int price) {
        validateSku(sku);
        validatePrice(price);
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        validateSku(sku);
        this.sku = sku;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", price=" + price +
                '}';
    }

    private void validateSku(String sku) {
        if (sku == null || sku.isEmpty()) {
            throw new IllegalArgumentException("Sku is required");
        }
    }

    private void validatePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Illegal price: " + price);
        }
    }
}
