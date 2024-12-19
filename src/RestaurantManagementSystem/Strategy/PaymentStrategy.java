package RestaurantManagementSystem.Strategy;

import RestaurantManagementSystem.Models.Order;

public interface PaymentStrategy {
    void processPayment(Order order);
    double calculateCharges(double amount);
}
