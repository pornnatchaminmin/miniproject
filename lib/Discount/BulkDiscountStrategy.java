package lib.Discount;
import lib.CartItem;

public class BulkDiscountStrategy {
     /*
     * Rep : private fianl int minimunBulk, private final double percentBulk
     * AF  : calculatePrice(item) คำนวณสินค้าในการลดราคาเป็นpercent
     */
    private final int minimumBulk;
    private final double percentBulk;
    public BulkDiscountStrategy(int minimumBulk, double percentBulk){
        this.minimumBulk = minimumBulk;
        this.percentBulk = percentBulk;
    }
    public double calculatePrice(CartItem item) {
        if(item.getQuantity() >= minimumBulk ){
            return (item.getProduct().getPrice()*item.getQuantity())*(1-percentBulk);
        }
        return item.getProduct().getPrice()* item.getQuantity();
    }
    
}
    

