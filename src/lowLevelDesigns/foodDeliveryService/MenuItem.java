package lowLevelDesigns.foodDeliveryService;

public class MenuItem {
    private String menuItemId;
    private String name;
    private String description;
    private String price;
    private boolean available;

    public MenuItem(String menuItemId, String name, String description, String price) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = true;
    }

    public void updateAvailability(boolean available) {
        this.available = available;
    }
}
