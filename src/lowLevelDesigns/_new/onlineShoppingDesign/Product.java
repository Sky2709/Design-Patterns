package lowLevelDesigns._new.onlineShoppingDesign;

public class Product {
    private String productId;
    private String productName;
    private String productDescription;
    private double price;
    private int quantity;

    public Product(String productId, String productName, String productDescription, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
    }

    public synchronized void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public synchronized boolean isAvailable(int quantity) {
        return this.quantity >= quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
