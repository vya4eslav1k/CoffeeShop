package cli;

import model.MenuItem;
import model.Order;
import service.OrderServiceImpl;

import java.util.List;

public class CoffeeShopApp {
    public static void main(String[] args) {
        Order order = new Order();
        List<MenuItem> catalog = List.of();
        OrderServiceImpl orderService = new OrderServiceImpl(order, catalog);

        while (true) {
            //TODO
        }
    }
}
