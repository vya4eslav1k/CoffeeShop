package model;

import java.util.List;

public class Order {

    List<MenuItem> menuItems;

    public Order(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public List<MenuItem> getItems() {
        return menuItems;
    }

    public double getTotalPrice() {
        return menuItems.stream().map(MenuItem::getPrice).reduce(0.0, Double::sum);
    }
}
