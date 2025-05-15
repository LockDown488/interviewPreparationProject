package ru.kopanev.spring.feature_9.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Client {
    private Long id;
    private String name;
    private int age;
    private List<Phone> phones;
}
