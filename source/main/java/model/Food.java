package model;

import java.util.Optional;

public class Food implements MenuItem{

    private final String name;
    private final double price;
    private final Optional<Double> calories;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
        this.calories = Optional.empty();
    }

    public Food(String name, double price, double calories) {
        this.name = name;
        this.price = price;
        this.calories = Optional.of(calories);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Food: " + name + ", Price: " + price;
    }

    public Optional<Double> getCalories() {
        return calories;
    }
}
