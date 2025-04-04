package mentorship.roadmap.coffeeshop.services;

import mentorship.roadmap.coffeeshop.models.Menu;
import mentorship.roadmap.coffeeshop.models.MenuItem;
import mentorship.roadmap.coffeeshop.models.Order;

import java.util.List;

public class OrderService {
    private final Menu menu;
    private final Order currentOrder;

    public OrderService(Menu menu) {
        this.menu = menu;
        this.currentOrder = new Order();
    }

    public void showMenu() {
        System.out.println("Меню:");
        menu.getAllItems().forEach(item -> System.out.println(item.getName() + " - " + item.getPrice() + " рублей"));
    }

    public void addItemToOrder(String itemName) {
        menu.findItemByName(itemName).ifPresent(item -> {
            currentOrder.addItem(item);
            System.out.println(item.getName() + " добавлено в заказ.");
        });
    }

    public void printCurrentOrder() {
        System.out.println("Текущий заказ:");
        List<MenuItem> items = currentOrder.getItems();
        if (items.isEmpty()) {
            System.out.println("Ваш заказ пуст.");
        } else {
            items.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice() + " рублей"));
        }
    }

    public void printTotal() {
        double total = currentOrder.calculateTotal();
        System.out.println("Итоговая стоимость заказа: " + total + " рублей");
    }

    public void finalizeOrder() {
        double total = currentOrder.calculateTotal();
        System.out.println("Ваш заказ на сумму " + total + " рублей завершён.");
        currentOrder.clear();
    }
}