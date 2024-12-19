package RestaurantManagementSystem.Repository;

import RestaurantManagementSystem.Models.Category;
import RestaurantManagementSystem.Models.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MenuRepositoryImpl implements MenuRepository {
    private List<MenuItem> menuItems;

    public MenuRepositoryImpl() {
        this.menuItems = new ArrayList<>();
    }

    @Override
    public void addItem(MenuItem item) {
        this.menuItems.add(item);
    }

    @Override
    public void updateItem(MenuItem item) {
//        for(MenuItem item: menuItems){
//
//        }
//        update what
    }

    @Override
    public void removeItem(UUID itemId) {
        menuItems.removeIf(menuItem-> menuItem.getId()==itemId);
    }

    @Override
    public List<MenuItem> getAllItems() {
        return menuItems;
    }

    @Override
    public List<MenuItem> getAllItemsByCategory(Category category) {
        return menuItems.stream().filter(menuItem-> menuItem.getCategory()==category).toList();
    }

    @Override
    public List<MenuItem> getAllItemsByVegType(boolean isVeg) {
        return menuItems.stream().filter(menuItem-> menuItem.isVeg()==isVeg).toList();
    }
}
