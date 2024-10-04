package lowLevelDesigns._new.onlineShoppingDesign;

import lowLevelDesigns._new.onlineShoppingDesign.payments.CreditCardPayment;
import lowLevelDesigns._new.onlineShoppingDesign.payments.Payment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        OnlineShoppingService onlineShoppingService = OnlineShoppingService.getInstance();

        User user1 = new User("U001", "Akash", "akash@gmail", "akash123");
        User user2 = new User("U002", "Aman", "aman@gmail", "aman123");
        User user3 = new User("U003", "Amit", "amit@gmail", "amit123");
        onlineShoppingService.registerUser(user1);
        onlineShoppingService.registerUser(user2);
        onlineShoppingService.registerUser(user3);

        Product product1 = new Product("P001", "Laptop", "Smart laptop", 50000, 10);
        Product product2 = new Product("P002", "Mobile", "Smart mobile", 20000, 20);
        Product product3 = new Product("P003", "Tablet", "Smart tablet", 10000, 30);
        onlineShoppingService.addProduct(product1);
        onlineShoppingService.addProduct(product2);
        onlineShoppingService.addProduct(product3);

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.additem(product1, 2);
        shoppingCart1.additem(product2, 3);
        shoppingCart1.additem(product3, 4);
        Payment payment1 = new CreditCardPayment();
        Order order1 = onlineShoppingService.placeOrder(user1, shoppingCart1, payment1);
        System.out.println("Order1: " + order1.getOrderId() + " Successfully placed");


        List<Product> searchedProducts = onlineShoppingService.searchProducts("mobile");
        System.out.println("Searched Products: ");
        for (Product product : searchedProducts) {
            System.out.println(product.getProductName());
        }

        ShoppingCart shoppingCart2 = new ShoppingCart();
        shoppingCart2.additem(searchedProducts.get(0), 2);
        Payment payment2 = new CreditCardPayment();
        Order order2 = onlineShoppingService.placeOrder(user1, shoppingCart2, payment2);
        System.out.println("Order2: " + order2.getOrderId() + " Successfully placed");

        List<Order> userOrders = user1.getOrders();
        System.out.println("User1 Orders: ");
        for (Order order : userOrders) {
            System.out.println("Order Id: " + order.getOrderId());
            System.out.println("Order Amount: " + order.getOrderTotal());
            System.out.println("Order Status: " + order.getOrderStatus());
        }
    }

}
