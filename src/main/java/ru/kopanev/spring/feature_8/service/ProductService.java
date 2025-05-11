package ru.kopanev.spring.feature_8.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.kopanev.spring.feature_8.entity.Product;

import java.util.List;

@Service
public class ProductService {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products.set(0, new Product(0, "Молоко", 200));
        products.set(1, new Product(1, "Колбаса", 350));
        products.set(2, new Product(2, "Сок", 150));
        products.set(3, new Product(3, "Сыр", 400));
        products.set(4, new Product(4, "Печенье", 100));
        products.set(5, new Product(5, "Энергетик", 200));
        products.set(6, new Product(6, "Пиво", 100));
        products.set(7, new Product(7, "Кофе", 600));
        products.set(8, new Product(8, "Масло", 300));
        products.set(9, new Product(9, "Овощи", 200));
    }

    public void printAll() {
        for (Product product : products) {
            System.out.println(product.getTitle() + " стоит " + product.getCost());
        }
    }

    public Product findByTitle(String title) {
        return products.stream()
                .filter(product -> product.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(String.format("Товар %s не найден", title)));
    }
}
