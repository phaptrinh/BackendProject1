package com.example.project1.service;

import com.example.project1.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllWithFilterJPA(Double price, String condition);

    List<Product> getAllWithPriceConditionMybatis(Double price, String condition);

    List<Product> getAllWithPriceRangeMybatis(Double minPrice, Double maxPrice);
}
