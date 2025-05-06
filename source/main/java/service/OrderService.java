package service;

import model.MenuItem;

import java.util.List;

public interface OrderService {
    void addMenuItem(String menuItemName);
    double getTotalPrice();
    void applyDiscount(double discount);
    List<MenuItem> getMenuItems();
}
