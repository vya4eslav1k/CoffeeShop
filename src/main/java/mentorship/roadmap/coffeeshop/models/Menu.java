package mentorship.roadmap.coffeeshop.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu {
    private final List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
        // Add some default items
        items.add(new Drink("Cappuccino", 5.0));
        items.add(new Food("Sandwich", 7.0));
        items.add(new Drink("Latte", 5.5));
        items.add(new Food("Burger", 8.5));
    }

    public List<MenuItem> getAllItems() {
        return items;
    }

    public Optional<MenuItem> findItemByName(String name) {
        return items.stream().filter(item -> item.getName().equalsIgnoreCase(name)).findFirst();
    }
}