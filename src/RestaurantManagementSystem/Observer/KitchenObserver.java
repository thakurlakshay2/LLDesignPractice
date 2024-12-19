package RestaurantManagementSystem.Observer;

import RestaurantManagementSystem.Models.Order;

public interface KitchenObserver {
    void onOrderStatusChanged(Order order);
}
