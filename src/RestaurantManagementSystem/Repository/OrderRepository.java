package RestaurantManagementSystem.Repository;

import RestaurantManagementSystem.Models.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    void createOrder(Order order);
    void updateOrder(Order order);
    List<Order> getActiveOrders();
    Order getOrderById(UUID orderId);
}
