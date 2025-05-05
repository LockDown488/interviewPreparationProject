package ru.kopanev.spring.feature_8.entity;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    @Getter
    private List<Product> cart = new ArrayList<>();

    public void add(Product product) {
        cart.add(product);
    }
}
