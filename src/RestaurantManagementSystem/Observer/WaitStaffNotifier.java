package RestaurantManagementSystem.Observer;

import RestaurantManagementSystem.Models.Order;
import RestaurantManagementSystem.Models.OrderStatus;

public class WaitStaffNotifier implements KitchenObserver{
    @Override
    public void onOrderStatusChanged(Order order) {
        if(order.getStatus() == OrderStatus.ready){
            System.out.println("Order" + order.getOrderId().toString() + " is Ready for serving at tale" + order.getTableId());
        }
    }
}
