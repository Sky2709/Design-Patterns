package lowLevelDesigns._new.vendingMachine;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map<Product, Integer> productInventory;

    public Inventory() {
        productInventory= new ConcurrentHashMap<>();
    }

    //this function will add or update the product in the inventory
    //for ex if product is already present in the inventory then it will update the quantity
    //if product is not present in the inventory then it will add the product in the inventory
    public void addOrUpdateProduct(Product product, int quantity) {
        productInventory.put(product, productInventory.getOrDefault(product, 0) + quantity);
    }

    //this function will remove or deduct the product from the inventory
    //for ex if product is already present in the inventory then it will deduct the quantity
    //if product is not present in the inventory then it will not do anything
    //if after deducting the quantity of the product becomes 0 then it will remove the product from the inventory
    public void removeOrDeductProduct(Product product, int quantity){
        productInventory.put(product, productInventory.getOrDefault(product, 0) - quantity);
        if (productInventory.get(product) == 0) {
            productInventory.remove(product);
        }
    }

    public int getProductQuantity(Product product) {
        return productInventory.getOrDefault(product, 0);
    }

    // making it null proof
    public boolean hasProduct(Product product) {
         if(productInventory.containsKey(product) && productInventory.get(product) > 0){
             System.out.println("Product is available: " + product.getName() + " Quantity: " + productInventory.get(product));
             return true;
         }
            System.out.println("Product is not available: " + product.getName());
            return false;
    }
}
