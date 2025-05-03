package ru.kopanev.spring.feature_3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Box<T extends Fruit> {

    private final List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        return fruits.stream()
                .mapToDouble(Fruit::getWeight)
                .sum();
    }

    public boolean compareTo(Box<?> another) {
        return this.getWeight() == another.getWeight();
    }

    public void transferTo(Box<T> another) {
        if (another == this) {
            System.out.println("Нельзя пересыпать фрукты из той же самой коробки");
            return;
        }

        another.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
