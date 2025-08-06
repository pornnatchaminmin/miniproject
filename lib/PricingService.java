package lib;

import java.util.ArrayList;

import lib.Discount.BogoDiscountStrategy;
import lib.Discount.BulkDiscountStrategy;
import lib.Discount.DiscountStrategy;

public class PricingService {
    /*
     * Rep : private record discount(String sku, DiscountStrategy discount), private ArrayList<discountRule> rule
     * AF  : addStrategy(sku, discount) เป็นMethod สำหรับการเพิ่มPromotionการลดราคา
     *       calculateItemPrice(item) เป็นMethod สำหรับการคำนวณว่าสินค้านั้นมีPromotionยังไง
     */
    private record discountRule(String sku, DiscountStrategy discount) {}
    private ArrayList<discountRule> rule = new ArrayList<>();

    /**
     * Method สำหรับการเพิ่มPromotionการลดราคา
     * @param sku รหัสสินค้าโดยที่จะเชื่อมโยงกับ ProductId
     * @param discount Promotion ที่ต้องการจะใช้
     */
    public void addStrategy(String sku, DiscountStrategy discount){
        for (int i=0; i< rule.size();i++) {
            if(rule.get(i).sku() == sku){
                rule.set(i, new discountRule(sku, discount));
                return;
            }
        }
        
        rule.add(new discountRule(sku, discount));
    }
    public double calculateItemPrice(CartItem item){
        for(int i=0;i<rule.size();i++){
            if(rule.get(i).sku() == item.getProduct().getProductId()){
                return rule.get(i).discount().calculatePrice(item);
            }
        }
        return item.getQuantity()*item.getProduct().getPrice();
    }
    public void addStrategy(String sku, BulkDiscountStrategy bulkDiscountStrategy) {
      
        throw new UnsupportedOperationException("Unimplemented method 'addStrategy'");
    }
    public void addStrategy(String sku, BogoDiscountStrategy bogoDiscountStrategy) {
       
        throw new UnsupportedOperationException("Unimplemented method 'addStrategy'");
    }
}