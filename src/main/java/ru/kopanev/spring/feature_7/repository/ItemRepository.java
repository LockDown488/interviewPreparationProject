package ru.kopanev.spring.feature_7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kopanev.spring.feature_7.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT SUM(i.val) FROM Item i")
    int sumAllVals();
}
