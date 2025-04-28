package ru.kopanev.spring.feature_6.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    
    private Long id;
    private String name;
    private BigDecimal price;
}
