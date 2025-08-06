package lib.Discount;

import lib.CartItem;

public class BogoDiscountStrategy extends DiscountStrategy {
    /*
     * Rep : private final int bogoNum
     * AF  : calculatePrice(item) การคำนวณสินค้าแบบ bogonum แถม bogonum โดยที่ Bogonum คือ ซื้อ Bogo จ่าย 1
     */
    private final int bogoNum;
    public BogoDiscountStrategy(){
        this.bogoNum = 2;
    }
    public BogoDiscountStrategy(int bogoNum){
        this.bogoNum = bogoNum;
    }
    public double calculatePrice(CartItem item) {
        return (item.getQuantity()/bogoNum+item.getQuantity()%bogoNum)*item.getProduct().getPrice();
    }
    
}