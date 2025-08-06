package lib.Discount;

import lib.CartItem;

public class DefaultPricingStrategy extends DiscountStrategy{
    public double calculatePrice(CartItem item) {
        return item.getProduct().getPrice() * item.getQuantity();
    }
    
}