package cli;

import enums.Commands;
import model.Drink;
import model.Food;
import model.MenuItem;
import model.Order;
import service.OrderService;
import service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShopApp {
    public static void main(String[] args) {
        Order order = new Order(new ArrayList<>());
        List<MenuItem> catalog = List.of(
                new Drink("Raph", 350),
                new Drink("Cappuccino", 250),
                new Drink("Flat white", 300),
                new Food("Cheesecake", 250),
                new Food("Donut", 150)
        );
        OrderService orderService = new OrderServiceImpl(order, catalog);
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                                \n
                                Type \'catalog\' to see all menu items
                                Type \'add\' to add a new item to order
                                Type \'discount\' to to apply discount
                                Type \'list\' to see order list
                                Type \'price\' to see order price
                                Type \'exit\' to exit
                                """);
            try {
                String command = scanner.nextLine();
                switch (Commands.valueOf(command.toUpperCase())) {
                    case MENU -> {
                        System.out.println("Menu:");
                        for (MenuItem menuItem : catalog) {
                            System.out.println(menuItem);
                        }
                    }
                    case ADD -> {
                        System.out.println("Type menu item to add");
                        String menuItemName = scanner.nextLine();
                        orderService.addMenuItem(menuItemName);
                        System.out.println(menuItemName + " added!");
                    }
                    case LIST -> {
                        System.out.println("Your order list:");
                        List<MenuItem> menuItems = orderService.getMenuItems();
                        for (MenuItem menuItem : menuItems) {
                            System.out.println(menuItem);
                        }
                    }
                    case PRICE -> {
                        System.out.println("Your order price: " + orderService.getTotalPrice());
                    }
                    case DISCOUNT -> {
                        System.out.println("Type the discount in percentage");
                        double discount = Double.parseDouble(scanner.nextLine());
                        orderService.applyDiscount(discount);
                        System.out.println(discount + "% discount applied!");
                    }
                    case EXIT -> {
                        System.out.println("Goodbye!");
                        isRunning = false;
                    }
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Unhandled exception: " + e.getMessage());
            }
        }
    }
}
