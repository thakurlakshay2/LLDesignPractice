package RestaurantManagementSystem.Service;

import RestaurantManagementSystem.Models.Order;
import RestaurantManagementSystem.Models.OrderStatus;
import RestaurantManagementSystem.Observer.KitchenObserver;
import RestaurantManagementSystem.Repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class KitchenService{
    private OrderRepository orderRepository;
    private List<KitchenObserver> observers;

    public KitchenService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.observers=new ArrayList<>();
    }

    public void updateOrderStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        orderRepository.updateOrder(order);
        notifyObservers(order);
    }

    private void notifyObservers(Order order) {
        for (KitchenObserver observer : observers) {
            observer.onOrderStatusChanged(order);
        }
    }
}
