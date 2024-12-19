package RestaurantManagementSystem.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Table {
    private UUID tableId;
    private boolean isOccupied;
    private List<Order> orders;

    public Table(boolean isOccupied) {
        this.tableId= UUID.randomUUID();
        this.isOccupied = isOccupied;
        this.orders = new ArrayList<>();
    }


    public UUID getTableId() {
        return tableId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setOrders(Order order) {

        this.orders.add(order);
    }
    private void setOrders(List<Order> order){
        this.orders.addAll(order);
    }
}
