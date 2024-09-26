package lowLevelDesigns._new.foodDeliveryService.orders;

import lowLevelDesigns._new.foodDeliveryService.MenuItem;

public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
}
