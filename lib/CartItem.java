package lib;
/*
 * ADT สำหรับการเก็บข้อมูลสินค้าและจำนวนโดยสามารถแก้ไขจำนวนได้
 */
public class CartItem {
    //Rep : private final Product product, private int quantity
    //AF : CartItem(product,quantity) สำหรับการเก็บข้อมูลทั้งข้อมูล Productและจำนวน quantity
    //     increaseQuanity(amount) สำหรับการเพิ่มจำนวนสินค้า
    //RI : ค่าProductต้องไม่เป็นnull && ค่าquanityต้องมากกว่า 0
    private final Product product;
    private int quantity;

    /**
     * การเก็บข้อมูลมายังclassนี้
     * @param product ข้อมูลสินค้าทั้งชื่อ, รหัสและราคา
     * @param quantity ข้อมูลจำนวนสินค้าทีจะเพิ่ม
     * @throws RuntimeException ("Error: Quantity <= 0") เมื่อproductเป็นnull||quantity <= 0
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        checkRep();
    }

    /**
     * เป็นระบบในการเพิ่มจำนวนสินค้า
     * @param amount จำนวนสินค้าที่จะเพิ่ม
     * @throws RuntimeException ("Error: Quantity <= 0") เมื่อproductเป็นnull||quantity <= 0
     */
    public void increasesQuanity(int amount) {
        this.quantity += amount;
        checkRep();
    }

    /**
     * เป็นระบบในการเรียกค่า Product ใน Class
     * @return ข้อมูล product
     */
    public Product getProduct() {
        return product;
    }
    
    /**
     * เป็นระบบในการเรียกค่า quantity ใน Class
     * @return ข้อมูล quantity
     */
    public int getQuantity() {
        return quantity;
    }

    private void checkRep() {
        if (this.quantity <= 0 || this.product == null) {
            throw new RuntimeException("Error: Quantity <= 0");
        }
    }
}