package lib;

import java.util.ArrayList;

public class ProductCatalog {
    /*
     * Rep : ArrayList<Product> arrayProduct
     * AF  : addProduct(product) เป็นMethod สำหรับการเพิ่มข้อมูลว่ามีสินค้าใดบ้าง
     *       findById(productId) เป็นMethod สำหรับการหาข้อมูลจากรหัสสินค้า
     * RI  : รหัสสินค้าต้องไม่ซ้ำกัน
     */
    private ArrayList<Product> arrayProduct = new ArrayList<>();

    /**
     * Method เพิ่มข้อมูลว่ามีสินค้าใดบ้างในร้าน
     * @param product สินค้าที่จะเพิ่ม
     */
    public void addProduct(Product product) {
        boolean check = true;
        for (int i = 0; i < arrayProduct.size(); i++) {
            if (arrayProduct.get(i).equals(product.getProductId())) {
                check = false;
                break;
            }
        }
        if (product != null && check) {
            arrayProduct.add(product);
        }
    }

    /**
     * Method ที่หาข้อมูลสินค้าจากรหัสสินค้า
     * @param productId รหัสสินค้าที่จะหา
     * @return ถ้าเจอจะส่งข้อมูล ข้อมูลสินค้า, ถ้าไม่เจอจะส่งค่าnull
     */
    public Product findById(String productId) {
        for (int i = 0; i < arrayProduct.size(); i++) {
            if(arrayProduct.get(i).equals(productId)){
                return arrayProduct.get(i);
            }
        }
        return null;
    }
}