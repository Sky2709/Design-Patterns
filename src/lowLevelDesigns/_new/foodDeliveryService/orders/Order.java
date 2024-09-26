package lowLevelDesigns._new.foodDeliveryService.orders;

import lowLevelDesigns._new.foodDeliveryService.Customer;
import lowLevelDesigns._new.foodDeliveryService.DeliveryAgent;
import lowLevelDesigns._new.foodDeliveryService.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private Restaurant restaurant;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private DeliveryAgent deliveryAgent;


    public Order(String orderId, Customer customer, Restaurant restaurant) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderItems=new ArrayList<>();
        this.orderStatus=OrderStatus.PENDING;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem){
        orderItems.remove(orderItem);
    }

    public void updateOrderStatus(OrderStatus orderStatus){
        this.orderStatus=orderStatus;
    }

    public void assignDeliveryAgent(DeliveryAgent deliveryAgent){
        this.deliveryAgent=deliveryAgent;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
