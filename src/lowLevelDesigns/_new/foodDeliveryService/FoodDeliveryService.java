package lowLevelDesigns._new.foodDeliveryService;

import lowLevelDesigns._new.foodDeliveryService.orders.Order;
import lowLevelDesigns._new.foodDeliveryService.orders.OrderItem;
import lowLevelDesigns._new.foodDeliveryService.orders.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

//this class is for the food delivery service
public class FoodDeliveryService {
    private static FoodDeliveryService foodDeliveryServiceInstance;
    private Map<String, Customer> customers; //customerId, Customer
    private Map<String, Restaurant> restaurants; //restaurantId, Restaurant
    private Map<String, Order> orders; //orderId, Order
    private Map<String, DeliveryAgent> deliveryAgents; //deliveryAgentId, DeliveryAgent

    private FoodDeliveryService() {
        customers = new ConcurrentHashMap<>();
        restaurants = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
        deliveryAgents = new ConcurrentHashMap<>();
    }

    public static synchronized FoodDeliveryService getInstance() {
        if (foodDeliveryServiceInstance == null) {
            foodDeliveryServiceInstance = new FoodDeliveryService();
        }
        return foodDeliveryServiceInstance;
    }


    public void registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public void registerDeliveryAgent(DeliveryAgent deliveryAgent) {
        deliveryAgents.put(deliveryAgent.getDeliveryAgentId(), deliveryAgent);
    }

    public List<Restaurant> getAvailableRestaurants() {
        return new ArrayList<>(restaurants.values());
    }

    public List<MenuItem> getRestaurantMenu(String restaurantId){
        Restaurant restaurant= restaurants.get(restaurantId);
        if (restaurant !=null){
            return restaurant.getMenu();
        }
        return new ArrayList<>();
    }

    public Order placeOrder(String customerId, String restaurantId,
                            List<OrderItem> orderItems){
        Customer customer= customers.get(customerId);
        Restaurant restaurant= restaurants.get(restaurantId);
        if (customer!=null && restaurant != null){
            Order order= new Order(generateOrderId(), customer, restaurant);
            for(OrderItem orderItem: orderItems){
                order.addOrderItem(orderItem);
            }
            orders.put(order.getOrderId(), order);
            notifyRestaurant(order);
            System.out.println("Order Placed: " + order.getOrderId());
            return order;
        }
        return null;
    }

    public void updateOrderStatus(String orderId, OrderStatus orderStatus){
        Order order=orders.get(orderId);
        if (order!=null){
            order.updateOrderStatus(orderStatus);
            notifyCustomer(order);
            if (orderStatus==OrderStatus.CONFIRMED){
                assignDeliveryAgent(order);
            }
        }
    }

    private void assignDeliveryAgent(Order order) {
        for (DeliveryAgent deliveryAgent:deliveryAgents.values()){
            if (deliveryAgent.isAvailable()){
                deliveryAgent.setAvailable(false);
                order.assignDeliveryAgent(deliveryAgent);
                notifyDeliveryAgent(order);
                break;
            }
        }
    }

    public void cancelOrder(String orderId){
        Order order= orders.get(orderId);
        if (order!=null && order.getOrderStatus()==OrderStatus.PENDING){
            order.updateOrderStatus(OrderStatus.CANCELLED);
            notifyCustomer(order);
            notifyRestaurant(order);
            System.out.println("Order Cancelled: " + order.getOrderId());
        }
    }

    private void notifyDeliveryAgent(Order order) {
    }

    private void notifyCustomer(Order order) {
    }

    private void notifyRestaurant(Order order) {
    }

    private String generateOrderId() {
        return "ORD" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

}
