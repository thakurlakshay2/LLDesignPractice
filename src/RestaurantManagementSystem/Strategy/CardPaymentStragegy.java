package RestaurantManagementSystem.Strategy;

import RestaurantManagementSystem.Models.Order;
import RestaurantManagementSystem.Models.PaymentStatus;

public class CardPaymentStragegy implements  PaymentStrategy{
    private static final double CARD_CHARGE_PERCENTAGE = 2.0;

    @Override
    public void processPayment(Order order) {
        order.setPaymentStatus(PaymentStatus.Success);
    }

    @Override
    public double calculateCharges(double amount) {
        return amount * (1 + CARD_CHARGE_PERCENTAGE / 100);
    }
}
