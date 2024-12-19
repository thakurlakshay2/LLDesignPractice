package RestaurantManagementSystem;

import RestaurantManagementSystem.Config.RestaurantConfig;
import RestaurantManagementSystem.Controller.RestrauntManager;
import RestaurantManagementSystem.Models.*;
import RestaurantManagementSystem.Repository.MenuRepositoryImpl;
import RestaurantManagementSystem.Repository.OrderRepository;
import RestaurantManagementSystem.Repository.OrderResositoryImpl;
import RestaurantManagementSystem.Service.KitchenService;
import RestaurantManagementSystem.Service.MenuService;
import RestaurantManagementSystem.Service.OrderService;
import RestaurantManagementSystem.Strategy.CardPaymentStragegy;
import RestaurantManagementSystem.Strategy.CashPaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RestrauntManager restrauntManager=new RestrauntManager();

        restrauntManager.setNumberOfTables(20);
        RestaurantConfig.getInstance().setTaxRate(0.10);

        OrderRepository orderRepository=new OrderResositoryImpl();
        //Initialising service
        MenuService menuService=new MenuService(new MenuRepositoryImpl());
        OrderService orderService=new OrderService(orderRepository);
        KitchenService kitchenService =new KitchenService(orderRepository);


        //add menu items
        MenuItem item1=new MenuItem("Vegetable curry",255,true, Category.Starters);
        MenuItem item2=new MenuItem("chaap",255,true, Category.Main_Course);
        MenuItem item3=new MenuItem("Chicken sandwitch",255,false, Category.Starters);
        MenuItem item4=new MenuItem("Chicken curry",255,false, Category.Main_Course);
        MenuItem item5=new MenuItem("Cake",255,false, Category.Deserts);

        menuService.addMenuItem(item1);
        menuService.addMenuItem(item2);
        menuService.addMenuItem(item3);
        menuService.addMenuItem(item4);
        menuService.addMenuItem(item5);

        OrderItem orderItem1=new OrderItem(item1,2);
        OrderItem orderItem2=new OrderItem(item3,2);
        List<OrderItem> orders=new ArrayList<>();
        orders.add(orderItem1);
        orders.add(orderItem2);

        Order order1=new Order(1,orders, OrderStatus.Placed,PaymentStatus.Pending);

        orderService.addItemsToOrder(order1,item5,2);

        System.out.println("Initial Order Details");
        System.out.println("Table: , "+ order1.getTableId());
        System.out.println("Items:" );
        for(OrderItem item: order1.getItems()){
            System.out.println("- " + item.getQuantity() + "x " + item.getItem().getName() +
                    " ($" + item.getItem().getPrice() + " each)");
        }

        System.out.println("\nPayment Options:");

        // Cash payment
        orderService.setPaymentStrategy(new CashPaymentStrategy());
        double cashTotal = orderService.calculateBill(order1);
        System.out.printf("Cash payment total: $%.2f%n", cashTotal);

        // Card payment
        orderService.setPaymentStrategy(new CardPaymentStragegy());
        double cardTotal = orderService.calculateBill(order1);
        System.out.printf("Card payment total (including 2%% charge): $%.2f%n", cardTotal);

        // Process the order in kitchen
        System.out.println("\nKitchen Order Processing:");
        kitchenService.updateOrderStatus(order1, OrderStatus.Preparing);
        System.out.println("Order status updated to: " + order1.getStatus());

        // Add more items to existing order
        System.out.println("\nAdding Dessert to Order:");
        orderService.addItemsToOrder(order1, item3, 2); // 2 brownies

        // Calculate final bill
        System.out.println("Final Order Details:");
        System.out.println("Items:");
        for (OrderItem item : order1.getItems()) {
            System.out.println("- " + item.getQuantity() + "x " + item.getItem().getName() +
                    " ($" + item.getItem().getPrice() + " each)");
        }

        // Final payment calculation
        orderService.setPaymentStrategy(new CashPaymentStrategy());
        double finalTotal = orderService.calculateBill(order1);
        System.out.printf("Final total (cash): $%.2f%n", finalTotal);

        // Complete the order
        kitchenService.updateOrderStatus(order1, OrderStatus.ready);
        kitchenService.updateOrderStatus(order1, OrderStatus.searved);
        orderService.processPayment(order1);

        // Menu filtering demonstration
        System.out.println("\nMenu Filtering Examples:");
        System.out.println("Vegetarian Starters:");
        List<MenuItem> vegStarters = menuService.filterMenu(Category.Starters, true);
        for (MenuItem item : vegStarters) {
            System.out.println("- " + item.getName() + " ($" + item.getPrice() + ")");
        }
    }
}
