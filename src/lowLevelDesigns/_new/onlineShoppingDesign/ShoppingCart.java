package lowLevelDesigns._new.onlineShoppingDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private Map<String, OrderItem> cartItems;

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }

    public void additem(Product product, int quantity){
        String productId=product.getProductId();
        if (cartItems.containsKey(productId)){
            OrderItem orderItem=cartItems.get(productId);
            quantity+=orderItem.getQuantity();
        }
        cartItems.put(productId,new OrderItem(product,quantity));
    }

    public void removeItem(String productId){
        cartItems.remove(productId);
    }

    public void updateQuantity(String productId, int quantity){
        OrderItem orderItem=cartItems.get(productId);
        if (orderItem!=null){
            cartItems.put(productId,new OrderItem(orderItem.getProduct(),quantity));
        }
    }

    public List<OrderItem> getCartItems(){
        return new ArrayList<>(cartItems.values());
    }

    public void clear(){
        cartItems.clear();
    }
}
