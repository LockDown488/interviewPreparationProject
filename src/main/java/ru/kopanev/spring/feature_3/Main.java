package ru.kopanev.spring.feature_3;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();
    private static final int APPLES_COUNT = 5;
    private static final int ORANGES_COUNT = 8;

    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        for (int i = 0; i < APPLES_COUNT; i++) {
            appleBox1.addFruit(new Apple());
            appleBox2.addFruit(new Apple());
        }

        for (int i = 0; i < ORANGES_COUNT; i++) {
            orangeBox1.addFruit(new Orange());
            orangeBox2.addFruit(new Orange());
        }

        // проверка метода compareTo
        if (appleBox1.compareTo(orangeBox1)) {
            System.out.println("Коробки имеют одинаковую массу");
        } else {
            System.out.println("Коробки имеют разную массу");
        }

        // проверка метода пересыпания фруктов из одной коробки в другую
        appleBox1.transferTo(appleBox2);
        System.out.println(String.format("Теперь в коробке %d фруктов", appleBox2.getFruits().size()));

        // проверка метода на свап 2 элементов массива
        String[] strings = {"asd", "aert", "dgggh", "iruf"};
        swap(strings, 0, 1);
        System.out.println(strings[0] + " " + strings[1]);

        // проверка метода преобразования массива в ArrayList
        List<String> str = toArrayList(strings);
        System.out.println(str.getClass());
    }

    private static <T> void swap(T[] array, int index1, int index2) {
        T element1 = array[index1];
        T element2 = array[index2];

        array[index1] = element2;
        array[index2] = element1;
    }

    private static <T> ArrayList<T> toArrayList(T[] array) {
        return new ArrayList<>(List.of(array));
    }
}
