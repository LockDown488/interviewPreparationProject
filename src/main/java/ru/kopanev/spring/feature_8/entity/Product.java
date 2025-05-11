package ru.kopanev.spring.feature_8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private int cost;
}
