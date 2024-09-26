package lowLevelDesigns._new.onlineShoppingDesign;

import lowLevelDesigns._new.onlineShoppingDesign.payments.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineShoppingService {
    private static OnlineShoppingService onlineShoppingServiceInstance;
    private Map<String, User> usersMap;
    private Map<String, Product> productsMap;
    private Map<String, Order> ordersMap;

    public OnlineShoppingService() {
        this.usersMap = new ConcurrentHashMap<>();
        this.productsMap = new ConcurrentHashMap<>();
        this.ordersMap = new ConcurrentHashMap<>();
    }

    public static OnlineShoppingService getInstance() {
        if (onlineShoppingServiceInstance == null) {
            return new OnlineShoppingService();
        }
        return onlineShoppingServiceInstance;
    }

    public void registerUser(User user) {
        usersMap.put(user.getUserId(), user);
    }

    public User getUser(String userId) {
        return usersMap.get(userId);
    }

    public void addProduct(Product product) {
        productsMap.put(product.getProductId(), product);
    }

    public Product getProduct(String productId) {
        return productsMap.get(productId);
    }

    public List<Product> searchProducts(String keyword) {
        List<Product> searchedProducts = new ArrayList<>();
        for (Product product : productsMap.values()) {
            if (product.getProductName().toLowerCase().contains(keyword.toLowerCase()) ||
                    product.getProductDescription().toLowerCase().contains(keyword.toLowerCase())) {
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }


    public synchronized Order placeOrder(User user, ShoppingCart shoppingCart, Payment payment) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItem orderItem : shoppingCart.getCartItems()) {
            Product product = orderItem.getProduct();
            int quantity = orderItem.getQuantity();
            if (product.isAvailable(quantity)) {
                product.updateQuantity(-quantity);
                orderItems.add(orderItem);
            }
        }

        if (orderItems.isEmpty()) {
            throw new IllegalStateException("No product available to place order");
        }

        String orderId = generateOrderId();
        Order order = new Order(orderId, user, orderItems);
        ordersMap.put(orderId, order);
        user.addOrder(order);
        shoppingCart.clear();

        if (payment.processPayment(order.getOrderTotal())) {
            order.setOrderStatus(OrderStatus.PROCESSING);
        } else {
            order.setOrderStatus(OrderStatus.CANCELLED);
            for (OrderItem orderItem : orderItems) {
                Product product = orderItem.getProduct();
                int quantity = orderItem.getQuantity();
                product.updateQuantity(quantity);
            }
        }
        return order;
    }

    private String generateOrderId() {
        return "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Order getOrder(String orderId) {
        return ordersMap.get(orderId);
    }
}
