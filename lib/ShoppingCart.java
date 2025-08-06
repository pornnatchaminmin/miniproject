package lib;

import java.util.ArrayList;
/*
 * ADT สำหรับการตะกร้าการซื้อของ
 */
public class ShoppingCart {
    /* Rep : private final PricingService pricingService, private final ProductCatalog productCatalog, private ArrayList<Cartitem> cartItems, private Product product
     * AF  : addItem(productId, quantity) เป็นMethod ที่สำหรับการเพิ่มข้อมูลลงไปในตะกร้าที่จะซื้อ
            removeItem(productId) เป็นMethod สำหรับการลบข้อมูลจากรหัสสินค้าที่รับ
            getTotalPrice() เป็นMethod สำหรับการคิดราคารวมของสินค้า
            getItemCount() เป็นMethod สำหรับการนับจำนวนข้อมูลในตะกร้า
            getClearCart() เป็นMedthod สำหรับการเคลียร์ข้อมูล
     * RI  : ตะกร้าต้องไม่มีข้อมูลซ้ำกันและตะกร้าต้องไม่ว่างเปล่า
     */
    private final PricingService pricingService;
    private final ProductCatalog productCatalog;
    private ArrayList<CartItem> cartItems = new ArrayList<>();
    private Product product;

    /**
     * สำหรับการSet ตะกร้าสินค้าโดยเลือกว่าจะใช้กลุ่มServiceแบบไหน และสินค้าแบบไหนในนั้น
     * @param pricingService กลุ่มService ที่เก็บข้อมูลPromotionของสินค้า
     * @param productCatalog กลุ่มของสินค้าที่ขาย
     */
    public ShoppingCart(PricingService pricingService, ProductCatalog productCatalog) {
        this.pricingService = pricingService;
        this.productCatalog = productCatalog;
    }

    /**
     * Method สำหรับการเพิ่มสินค้าในตะกร้า
     * @param productId รหัสสินค้าที่จะเพิ่ม
     * @param quantity  จำนวนสินค้าที่จะเพิ่ม
     * @throws RuntimeException ("Error : Same ProductId")ถ้ารหัสสินค้ามีเหมือนกันในตะกร้า
     * @throws RuntimeException ("Error : Null") ถ้าไม่มีสินค้านั้นในProductCatalog
     */
    public void addItem(String productId, int quantity) {
        product = productCatalog.findById(productId);
        boolean check = true;
        if (product != null && quantity >0) {
            for (int i = 0; i < cartItems.size(); i++) {
                if (cartItems.get(i).getProduct().equals(productId)) {
                    cartItems.get(i).increasesQuanity(quantity);
                    check = false;
                    break;
                }
            }
            if (check) {
                cartItems.add(new CartItem(product, quantity));
            }
        }
        checkRep();
    }

    /**
     * Method สำหรับการลบสินค้าในตะกร้าสินค้าโดยดูจากรหัสสินค้า
     * @param productId รหัสสินค้าที่จะลบ
     */
    public void removeItem(String productId) {
        Product product = productCatalog.findById(productId);
        if (product != null) {
            for (int i = 0; i < cartItems.size(); i++) {
                if (cartItems.get(i).getProduct().equals(productId)) {
                    cartItems.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Method สำหรับการคิดคำนวณสินค้าที่ชิ้นในตะกร้า
     * @return ราคาสินค้ารวม
     */
    public double getTotalPrice(){
        double sum = 0;
        for (CartItem cartItem : cartItems) {
            sum += pricingService.calculateItemPrice(cartItem);
        }
        return sum;
    }

    /**
     * Method สำหรับการเช็กว่ามีจำนวนสินค้าในตะกร้าเท่าใด
     * @return จำนวนสินค้าทั้งหมด
     */
    public int getItemCount(){
        return cartItems.size();
    }

    /**
     * Method สำหรับการเคลียร์ข้อมูลสินค้าทั้งตะกร้า
     */
    public void clearCart(){
        cartItems.clear();
    }

    private void checkRep(){
        if(cartItems == null){
            throw new  RuntimeException("Error : Null");
        }
        for(int i =0; i< cartItems.size() ;i++){
            for(int j = 0; j < cartItems.size() ; j++){
                if(i!= j){
                    if(cartItems.get(i).getProduct().equals(cartItems.get(j))){
                        throw new RuntimeException("Error : Same ProductId");
                    }
                }
            }
        }
    }
}
