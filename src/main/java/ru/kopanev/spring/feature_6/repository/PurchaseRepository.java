package ru.kopanev.spring.feature_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kopanev.spring.feature_6.entity.Purchase;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByCustomerId(Long customerId);

    @Query(value = "SELECT p FROM Purchase p JOIN p.product pr WHERE pr.name = :productName")
    List<Purchase> findByProductName(@Param("productName") String productName);
}
