package ru.kopanev.spring.feature_6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kopanev.spring.feature_6.entity.Customer;
import ru.kopanev.spring.feature_6.entity.Product;
import ru.kopanev.spring.feature_6.entity.Purchase;
import ru.kopanev.spring.feature_6.repository.CustomerRepository;
import ru.kopanev.spring.feature_6.repository.ProductRepository;
import ru.kopanev.spring.feature_6.repository.PurchaseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;

    public List<Purchase> showProductsByPerson(String customerName) {
        Customer customer = customerRepository.findByName(customerName);

        return purchaseRepository.findByCustomerId(customer.getId());
    }

    public List<Customer> findPersonsByProductTitle(String productName) {
        return purchaseRepository.findByProductName(productName).stream()
                .map(Purchase::getCustomer)
                .toList();
    }

    @Transactional
    public void removeCustomer(String customerName) {
        Customer customer = customerRepository.findByName(customerName);
        customerRepository.deleteById(customer.getId());
    }

    @Transactional
    public void removeProduct(String productName) {
        Product product = productRepository.findByName(productName);
        productRepository.deleteById(product.getId());
    }

    @Transactional
    public void buyProductByCustomer(String customerName, String productName) {
        Customer customer = customerRepository.findByName(customerName);
        Product product = productRepository.findByName(productName);

        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setProduct(product);

        purchaseRepository.save(purchase);
    }
}
