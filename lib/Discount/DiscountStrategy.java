package lib.Discount;
import lib.CartItem;
/*
 * interface สำหรับการเรียกfunctionในการคำนวณสินค้าตามPromotionนั้นๆ
 */

public abstract class DiscountStrategy {
        public abstract double calculatePrice(CartItem item);
    
}
