package RestaurantManagementSystem.Strategy;

import RestaurantManagementSystem.Models.Order;
import RestaurantManagementSystem.Models.PaymentStatus;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(Order order) {
        order.setPaymentStatus(PaymentStatus.Success);
    }

    @Override
    public double calculateCharges(double amount) {
        //right now assuming 0 fees and taxes
        return amount;
    }
}
