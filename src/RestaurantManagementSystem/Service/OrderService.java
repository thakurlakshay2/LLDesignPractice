package RestaurantManagementSystem.Service;

import RestaurantManagementSystem.Config.RestaurantConfig;
import RestaurantManagementSystem.Models.MenuItem;
import RestaurantManagementSystem.Models.Order;
import RestaurantManagementSystem.Models.OrderItem;
import RestaurantManagementSystem.Repository.OrderRepository;
import RestaurantManagementSystem.Strategy.PaymentStrategy;

public class OrderService {
    private OrderRepository orderRepository;
    private PaymentStrategy paymentStrategy;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void setPaymentStrategy(PaymentStrategy strategy){
        this.paymentStrategy=strategy;
    }
    public  double calculateBill(Order order){
        double subtotal= order.getItems().stream().mapToDouble(item-> item.getQuantity()*item.getItem().getPrice())
                .sum();
        double tax= subtotal* RestaurantConfig.getInstance().getTaxRate();
        double total= subtotal+tax;

        if(paymentStrategy !=null){
            total= paymentStrategy.calculateCharges(total);
        }
        return  total;
    }

    public  void processPayment(Order order){
        if(paymentStrategy!=null){
            paymentStrategy.processPayment(order);
        }
    }
    public  void addItemsToOrder(Order order , MenuItem item, int quantity){
        OrderItem orderItem=new OrderItem(item,quantity);
        order.setItem(orderItem);
        order.setTotalAmount(calculateBill(order));

        orderRepository.updateOrder(order);

    }
}
