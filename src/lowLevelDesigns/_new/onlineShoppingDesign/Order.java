package lowLevelDesigns._new.onlineShoppingDesign;


import java.util.List;

public class Order {
    private String orderId;
    private User user;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private double orderTotal;

    public Order(String orderId, User user, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.user = user;
        this.orderItems = orderItems;
        this.orderStatus = OrderStatus.PENDING;
        this.orderTotal=calculateOrderTotal();
    }

    private double calculateOrderTotal() {
        return orderItems.stream().mapToDouble(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity()).sum();
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public double getOrderTotal() {
        return orderTotal;
    }
}
