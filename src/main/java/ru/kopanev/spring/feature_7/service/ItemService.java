package ru.kopanev.spring.feature_7.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kopanev.spring.feature_7.entity.Item;
import ru.kopanev.spring.feature_7.repository.ItemRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ItemService {

    @Value("${spring.data.thread.thread-size}")
    private int threadPoolSize;

    private final ItemRepository itemRepository;
    private final ExecutorService executorService;

    @Retryable(retryFor = OptimisticEntityLockException.class, maxAttempts = 5)
    @Transactional
    public void incrementRandomEntry() throws InterruptedException {
        long randomEntryId = ThreadLocalRandom.current().nextLong(1, 41);

        Item item = itemRepository.findById(randomEntryId)
                .orElseThrow(() -> new EntityNotFoundException("Item not found."));

        Thread.sleep(5000);

        item.setVal(item.getVal() + 1);
        itemRepository.save(item);
    }

    public void run() {
        for (int i = 0; i < threadPoolSize; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 20; j++) {
                    try {
                        incrementRandomEntry();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        executorService.shutdown();

        int total = itemRepository.sumAllVals();
        System.out.println(total);
    }
}
