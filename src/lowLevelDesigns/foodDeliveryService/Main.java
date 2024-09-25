package lowLevelDesigns.foodDeliveryService;

import lowLevelDesigns.foodDeliveryService.orders.Order;
import lowLevelDesigns.foodDeliveryService.orders.OrderItem;
import lowLevelDesigns.foodDeliveryService.orders.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        System.out.println("Running Food Delivery Service");
        FoodDeliveryService foodDeliveryService= new FoodDeliveryService();

        Customer customer1= new Customer("C001", "Ramesh Kumar", "ramesh@yahoo", "9876543210");
        Customer customer2= new Customer("C002", "Mahesh Kumar", "mahesh@google", "9876543211");
        foodDeliveryService.registerCustomer(customer1);
        foodDeliveryService.registerCustomer(customer2);

        List<MenuItem> restaurantMenu1= new ArrayList<>();
        restaurantMenu1.add(new MenuItem("M001", "Dosa", "Spicy", "50"));
        restaurantMenu1.add(new MenuItem("M002", "Idly", "Healthy", "30"));
        restaurantMenu1.add(new MenuItem("M003", "Vada", "Crispy", "40"));

        Restaurant restaurant1= new Restaurant("R001", "Sagar Ratna", "MG Road", restaurantMenu1);
        foodDeliveryService.registerRestaurant(restaurant1);

        List<MenuItem> restaurantMenu2= new ArrayList<>();
        restaurantMenu2.add(new MenuItem("M004", "Pizza", "Cheesy", "150"));
        restaurantMenu2.add(new MenuItem("M005", "Burger", "Tasty", "100"));

        Restaurant restaurant2= new Restaurant("R002", "Dominos", "Indiranagar", restaurantMenu2);
        foodDeliveryService.registerRestaurant(restaurant2);

        DeliveryAgent deliveryAgent1= new DeliveryAgent("DA001", "Pankaj", "9876543212");
        DeliveryAgent deliveryAgent2= new DeliveryAgent("DA002", "Sanjay", "9876543213");

        foodDeliveryService.registerDeliveryAgent(deliveryAgent1);
        foodDeliveryService.registerDeliveryAgent(deliveryAgent2);

        List<OrderItem> orderItems= new ArrayList<>();
        orderItems.add(new OrderItem(restaurantMenu1.get(0), 2));
        orderItems.add(new OrderItem(restaurantMenu1.get(1), 1));

        Order order=foodDeliveryService.placeOrder(customer1.getId(), restaurant1.getId(), orderItems);

        foodDeliveryService.updateOrderStatus(order.getOrderId(), OrderStatus.CONFIRMED);
        System.out.println("Order Status Updated: "+order.getOrderStatus());

        Order order2=foodDeliveryService.placeOrder(customer2.getId(), restaurant2.getId(), List.of(new OrderItem(restaurantMenu2.get(0), 1), new OrderItem(restaurantMenu2.get(1), 2)));
        foodDeliveryService.cancelOrder(order2.getOrderId());
    }
}
