package RestaurantManagementSystem.Models;


import java.util.UUID;

public class MenuItem {
    private UUID id;
    private String name;
    private double price;
    private boolean isVeg;
    private Category category;

    public MenuItem(String name, double price, boolean isVeg, Category category) {
        this.id= UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.isVeg = isVeg;
        this.category = category;
    }

    //getters
    public Category getCategory() {
        return category;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
    //setters


    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVeg(boolean veg) {
        isVeg = veg;
    }
}
