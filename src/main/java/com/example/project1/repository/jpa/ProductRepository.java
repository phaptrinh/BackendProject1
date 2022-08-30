package com.example.project1.repository.jpa;

import com.example.project1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByPriceEquals(Double price);

    List<Product> findAllByPriceLessThan(Double price);

    List<Product> findAllByPriceGreaterThan(Double price);
}
