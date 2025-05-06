package service;

import model.MenuItem;
import model.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final Order order;
    private final List<MenuItem> catalog;

    public OrderServiceImpl(Order order, List<MenuItem> catalog) {
        this.order = order;
        this.catalog = catalog;
    }

    @Override
    public void addMenuItem(String menuItemName) {
        //TODO
    }

    @Override
    public double getTotalPrice() {
        //TODO
        return 0;
    }

    @Override
    public void applyDiscount(double discount) {
        //TODO
    }

    @Override
    public List<MenuItem> getMenuItems() {
        //TODO
        return List.of();
    }
}
