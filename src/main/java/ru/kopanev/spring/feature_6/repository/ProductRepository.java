package ru.kopanev.spring.feature_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kopanev.spring.feature_6.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String productName);
}
