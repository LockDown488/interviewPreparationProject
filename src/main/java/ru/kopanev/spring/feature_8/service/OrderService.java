package ru.kopanev.spring.feature_8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kopanev.spring.feature_8.entity.Cart;
import ru.kopanev.spring.feature_8.entity.Product;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final Cart cart;

    public void printCart() {
        for (Product product : cart.getCart()) {
            System.out.println(product.getTitle() + " стоит " + product.getCost());
        }
        System.out.println(totalSum());
    }

    private int totalSum() {
        return cart.getCart().stream()
                .map(product -> product.getCost())
                .mapToInt(Integer::intValue)
                .sum();
    }
}
