package RestaurantManagementSystem.Repository;

import RestaurantManagementSystem.Models.Order;
import RestaurantManagementSystem.Models.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderResositoryImpl implements OrderRepository{
    private List<Order> orders;

    public OrderResositoryImpl() {
        this.orders=new ArrayList<>();
    }

    @Override
    public void createOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public void updateOrder(Order order) {
        //update what
    }

    @Override
    public List<Order> getActiveOrders() {
        return orders.stream().filter(order-> order.getStatus()!= OrderStatus.searved).toList();
    }

    @Override
    public Order getOrderById(UUID orderId) {
        for(Order order:orders){
            if(order.getOrderId()==orderId){
                return order;
            }
        }

        return null;
    }
}
