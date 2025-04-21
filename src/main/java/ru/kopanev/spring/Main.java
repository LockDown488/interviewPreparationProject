package ru.kopanev.spring;

import ru.kopanev.spring.feature_1.Animal;
import ru.kopanev.spring.feature_1.Cat;
import ru.kopanev.spring.feature_1.Dog;
import ru.kopanev.spring.feature_1.Tiger;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("Барсик", 200, 0);
        animals[1] = new Dog("Бобик", 500, 10);
        animals[2] = new Tiger("Тигр", 700, 10000);

        for (Animal animal : animals) {
            animal.run(100);
            animal.swim(20);
        }
    }
}