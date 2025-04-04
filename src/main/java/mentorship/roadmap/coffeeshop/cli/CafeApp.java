package mentorship.roadmap.coffeeshop.cli;

import mentorship.roadmap.coffeeshop.models.Menu;
import mentorship.roadmap.coffeeshop.services.OrderService;

import java.util.Scanner;

public class CafeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        OrderService orderService = new OrderService(menu);

        boolean running = true;
        while (running) {
            System.out.println("1. Показать меню");
            System.out.println("2. Добавить в заказ");
            System.out.println("3. Показать заказ");
            System.out.println("4. Итоговая сумма");
            System.out.println("5. Завершить заказ");
            System.out.println("6. Выход");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> orderService.showMenu();
                case "2" -> {
                    System.out.print("Введите название позиции: ");
                    String itemName = scanner.nextLine();
                    orderService.addItemToOrder(itemName);
                }
                case "3" -> orderService.printCurrentOrder();
                case "4" -> orderService.printTotal();
                case "5" -> orderService.finalizeOrder();
                case "6" -> running = false;
                default -> System.out.println("Неверный ввод.");
            }
        }

        System.out.println("Спасибо за визит!");
    }
}