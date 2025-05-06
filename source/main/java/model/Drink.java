package model;

import java.util.Optional;

public class Drink implements MenuItem {

    private final String name;
    private final double price;
    private final Optional<Double> volume;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
        this.volume = Optional.empty();
    }

    public Drink(String name, double price, double volume) {
        this.name = name;
        this.price = price;
        this.volume = Optional.of(volume);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public Optional<Double> getVolume() {
        return volume;
    }
}
