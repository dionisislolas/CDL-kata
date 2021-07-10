package org.example.entites;

public class SpecialOffer {
    private int quantity;
    private int offerPrice;

    public SpecialOffer() {
    }

    public SpecialOffer(int quantity, int offerPrice) {
        validateQuantity(quantity);
        validateOfferPrice(offerPrice);
        this.quantity = quantity;
        this.offerPrice = offerPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(int offerPrice) {
        validateOfferPrice(offerPrice);
        this.offerPrice = offerPrice;
    }

    @Override
    public String toString() {
        return "SpecialOffer{" +
                "quantity=" + quantity +
                ", offerPrice=" + offerPrice +
                '}';
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Illegal quantity: " + quantity);
        }
    }

    private void validateOfferPrice(int offerPrice) {
        if (offerPrice <= 0) {
            throw new IllegalArgumentException("Illegal offer price: " + offerPrice);
        }
    }
}
