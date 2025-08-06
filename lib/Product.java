package lib;
/*
 * ADT สำรหับการเก็บข้อมูล product โดยที่เก็บแล้วไม่สามารถแก้ไขใหม่ได้
 */
public class Product {
    //Rep : private final String productId,private final String productName, private final double price
    //AF  : Product(productId, ProductName, price) เป็นmethodสำหรับการSetค่าเริ่มต้นของสินค้านั้นๆ
    //      equals(productId) เป็นmethodสำหรับเช็กproductIdว่าตรงกันไหม
    //RI  : ProductId ต้องไม่เป็น  null, ProductName ต้องไม่เป็น Null, price ต้องไม่น้อยกว่าหรือเท่ากับ 0
    private final String productId;
    private final String productName;
    private final double price;
    
    /**
     * การเก็บข้อมูลจำพวก Productมาไว้ในนี้
     * @param productId รหัสสินค้า
     * @param productName ชื่อสินค้า
     * @param price ราคาสินค้า
     * @throws RuntimeException ("Error: productId or productName = null / price <= 0") เมื่อproductId == null || productName == null || price <= 0
     */
    public Product(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        checkRep();
    }

    /**
     * ระบบไว้สำหรับเทียบ productId ของ Object product
     * @param productId รหัสสินค้า
     * @return true เมื่อรหัสสินค้าเหมือนกัน,false เมื่อรหัสสินค้าไม่เหมือนกัน
     */
    public boolean equals(String productId) {
        if (this.productId == productId) {
            return true;
        }
        return false;
    }

    /**
     * เป็นระบบในการเรียกค่า Price ใน Class
     * @return ข้อมูล Price
     */
    public double getPrice() {
        return price;
    }

    /**
     * เป็นระบบในการเรียกค่า ProductId ใน Class
     * @return ข้อมูล ProductId
     */
    public String getProductId() {
        return productId;
    }
    
    /**
     * เป็นระบบในการเรียกค่า ProductName ใน Class
     * @return ข้อมูล ProductName
     */
    public String getProductName() {
        return productName;
    }

    private void checkRep() {
        if (productId == null || productName == null || price <= 0) {
            throw new RuntimeException("Error: productId or productName = null / price <= 0");
        }
    }
}