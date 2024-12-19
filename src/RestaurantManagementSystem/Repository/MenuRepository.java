package RestaurantManagementSystem.Repository;

import RestaurantManagementSystem.Models.Category;
import RestaurantManagementSystem.Models.MenuItem;

import java.util.List;
import java.util.UUID;

public interface MenuRepository {
    void addItem(MenuItem item);
    void updateItem(MenuItem item);
    void removeItem(UUID itemId);
    List<MenuItem> getAllItems();
    List<MenuItem> getAllItemsByCategory(Category category);
    List<MenuItem> getAllItemsByVegType(boolean isVeg);
}
