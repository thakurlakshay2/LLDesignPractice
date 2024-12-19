package RestaurantManagementSystem.Models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID orderId;
    private int tableId;
    private List<OrderItem> items;
    private double totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private Date orderTime;



    public Order(int tableId, List<OrderItem> items, OrderStatus status, PaymentStatus paymentStatus) {
        this.orderId= UUID.randomUUID();
        this.tableId = tableId;
        this.items = items;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.totalAmount=0.0;
        this.orderTime = orderTime;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public int getTableId() {
        return tableId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setItem(OrderItem items) {
        this.items.add( items);
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
