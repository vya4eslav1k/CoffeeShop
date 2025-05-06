package service;

import model.MenuItem;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final Order order;
    private double discount;
    private final List<MenuItem> catalog;

    public OrderServiceImpl(Order order, List<MenuItem> catalog) {
        this.order = order;
        this.catalog = catalog;
    }

    @Override
    public void addMenuItem(String menuItemName) {
        for (MenuItem menuItem : catalog) {
            if (menuItem.getName().equalsIgnoreCase(menuItemName.toUpperCase())) {
                order.addItem(menuItem);
                return;
            }
        }
        throw new IllegalArgumentException("Item " + menuItemName + " not found in catalog");
    }

    @Override
    public double getTotalPrice() {
        return order.getTotalPrice() * (1 - discount*0.01);
    }

    @Override
    public void applyDiscount(double discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        this.discount = discount;
    }

    @Override
    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(order.getItems());
    }
}
