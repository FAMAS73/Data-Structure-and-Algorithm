import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IMS {
    // HashMap เพื่อเก็บจำนวนสินค้าโดยใช้รหัสสินค้าเป็น key
    private Map<String, Integer> inventory = new HashMap<>();

    // List เพื่อเก็บรายการสินค้า
    private List<ims.Product> productList = new ArrayList<>();

    // เพิ่มสินค้าในคลัง
    public void addProduct(String productId, String productName, int quantity) {
        if (inventory.containsKey(productId)) {
            // ถ้าสินค้ามีอยู่แล้ว อัพเดตจำนวนสินค้าใน HashMap
            inventory.put(productId, inventory.get(productId) + quantity);

            // อัพเดตจำนวนสินค้าใน List
            for (ims.Product product : productList) {
                if (product.getProductId().equals(productId)) {
                    product.setQuantity(product.getQuantity() + quantity);
                    return;
                }
            }
        } else {
            // ถ้าสินค้าใหม่ ให้เพิ่มลงใน HashMap และ List
            inventory.put(productId, quantity);
            productList.add(new ims.Product(productId, productName, quantity));
        }
    }

    // แสดงรายการสินค้าทั้งหมด
    public void displayInventory() {
        for (ims.Product product : productList) {
            System.out.println("ims.Product ID: " + product.getProductId() +
                    ", ims.Product Name: " + product.getProductName() +
                    ", Quantity: " + product.getQuantity());
        }
    }

    public static void main(String[] args) {
        IMS ims = new IMS();
        ims.addProduct("P1", "ims.Product A", 10);
        ims.addProduct("P2", "ims.Product B", 5);
        ims.addProduct("P1", "ims.Product A", 3); // เพิ่มสินค้า P1 อีก 3 ชิ้น
        ims.displayInventory();
    }
}

