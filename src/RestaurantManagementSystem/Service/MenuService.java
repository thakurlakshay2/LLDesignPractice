package RestaurantManagementSystem.Service;

import RestaurantManagementSystem.Models.Category;
import RestaurantManagementSystem.Models.MenuItem;
import RestaurantManagementSystem.Repository.MenuRepository;

import java.util.List;

public class MenuService {
    private  MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenuItem(MenuItem item){
        menuRepository.addItem(item);
    }
    public List<MenuItem> filterMenu(Category category,Boolean isVeg){
        if( category !=null && isVeg != null){
            return menuRepository.getAllItemsByCategory(category).stream()
                    .filter(item -> isVeg.equals(item.isVeg())).toList();
        }

        return menuRepository.getAllItems();
    }
}
