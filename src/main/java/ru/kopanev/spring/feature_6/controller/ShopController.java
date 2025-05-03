package ru.kopanev.spring.feature_6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kopanev.spring.feature_6.entity.Customer;
import ru.kopanev.spring.feature_6.entity.Purchase;
import ru.kopanev.spring.feature_6.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/{customerName}/purchases")
    public List<Purchase> showProductsByPerson(@PathVariable String customerName) {
        return shopService.showProductsByPerson(customerName);
    }

    @GetMapping("/{productName}/customers")
    public List<Customer> findPersonsByProductTitle(@PathVariable String productName) {
        return shopService.findPersonsByProductTitle(productName);
    }

    @DeleteMapping("/delete/{customerName}")
    public void removeCustomer(@PathVariable String customerName) {
        shopService.removeCustomer(customerName);
    }

    @DeleteMapping("/delete/{productName}")
    public void removeProduct(@PathVariable String productName) {
        shopService.removeProduct(productName);
    }

    @PostMapping("/buy/{customerName}/{productName}")
    public void buyProductByCustomer(
            @PathVariable String customerName,
            @PathVariable String productName) {
        shopService.buyProductByCustomer(customerName, productName);
    }
}
