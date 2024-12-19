package RestaurantManagementSystem.Models;

public class OrderItem {
    private MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
