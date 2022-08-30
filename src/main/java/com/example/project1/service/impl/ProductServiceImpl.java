package com.example.project1.service.impl;

import com.example.project1.entity.Product;
import com.example.project1.exception.RecordNotFoundException;
import com.example.project1.repository.jpa.ProductRepository;
import com.example.project1.repository.mybatis.ProductMybatisRepository;
import com.example.project1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Resource
    ProductMybatisRepository productMybatisRepository;

    @Override
    public List<Product> getAllWithFilterJPA(Double price, String condition) {
        switch (condition) {
            case "EQUAL":
                return productRepository.findAllByPriceEquals(price);
            case "LESS_THAN":
                return productRepository.findAllByPriceLessThan(price);
            case "GREATER_THAN":
                return productRepository.findAllByPriceGreaterThan(price);
            default:
                throw new IllegalArgumentException("Invalid condition");

        }
    }

    @Override
    public List<Product> getAllWithPriceConditionMybatis(Double price, String condition) {
        switch (condition) {
            case "EQUAL":
            case "LESS_THAN":
            case "GREATER_THAN":
                var products = productMybatisRepository.getAllByPriceCondition(price, condition);
                if (products.size() == 0) {
                    throw new RecordNotFoundException("Not found available products");
                }
                return products;

            default:
                throw new IllegalArgumentException("Invalid condition");

        }
    }

    @Override
    public List<Product> getAllWithPriceRangeMybatis(Double minPrice, Double maxPrice) {
        var products = productMybatisRepository.getAllByPriceRange(minPrice, maxPrice);
        if (products.size() == 0) {
            throw new RecordNotFoundException("Not found available products");
        }
        return products;
    }
}
