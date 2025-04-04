package mentorship.roadmap.coffeeshop.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void clear() {
        items.clear();
    }
}