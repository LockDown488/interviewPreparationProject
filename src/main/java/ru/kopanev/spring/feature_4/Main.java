package ru.kopanev.spring.feature_4;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();

        directory.addPhoneNumber("Иванов", "89115556677");
        directory.addPhoneNumber("Иванов", "89115556677"); // проверка на удаление дубликатов
        directory.addPhoneNumber("Петров", "89991234567");
        directory.addPhoneNumber("Семенов", "89452347890");
        directory.addPhoneNumber("Иванов", "89001002030");

        System.out.println(directory.getPhoneNumber("Иванов"));

        // проверка метода для подсчета уникальных элементов массива
        String[] words = {
                "яблоко", "банан", "яблоко", "апельсин", "виноград",
                "банан", "киви", "яблоко", "груша", "вишня",
                "киви", "лимон", "арбуз", "виноград", "слива"
        };

        Map<String, Long> filteredWords = findUniqueWords(words);

        for (Map.Entry<String, Long> entry : filteredWords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Long> findUniqueWords(String[] words) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}
