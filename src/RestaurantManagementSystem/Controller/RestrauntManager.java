package RestaurantManagementSystem.Controller;

import RestaurantManagementSystem.Config.RestaurantConfig;
import RestaurantManagementSystem.Models.Order;
import RestaurantManagementSystem.Repository.MenuRepositoryImpl;
import RestaurantManagementSystem.Repository.OrderRepository;
import RestaurantManagementSystem.Repository.OrderResositoryImpl;
import RestaurantManagementSystem.Service.KitchenService;
import RestaurantManagementSystem.Service.MenuService;
import RestaurantManagementSystem.Service.OrderService;
import RestaurantManagementSystem.Strategy.CardPaymentStragegy;

public class RestrauntManager {
    private MenuService menuService;
    private OrderService orderService;
    private KitchenService kitchenService;
    private RestaurantConfig config;

    public RestrauntManager() {
        this.config=RestaurantConfig.getInstance();
        this.menuService = new MenuService(new MenuRepositoryImpl());
        OrderRepository orderRepository=new OrderResositoryImpl();
        this.orderService=new OrderService(orderRepository);
        this.kitchenService=new KitchenService(orderRepository);
    }

    public void setNumberOfTables(int tables){
        config.setNumberOfTables(tables);
    }
}
