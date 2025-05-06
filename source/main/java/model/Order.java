package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    List<MenuItem> menuItems;

    void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    List<MenuItem> getItems() {
        return menuItems;
    }

    double getTotalPrice() {
        return menuItems.stream().map(MenuItem::getPrice).reduce(0.0, Double::sum);
    }
}
