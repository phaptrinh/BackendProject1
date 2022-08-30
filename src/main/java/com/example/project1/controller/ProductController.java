package com.example.project1.controller;

import com.example.project1.payload.response.BaseResponse;
import com.example.project1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/price-condition")
    public ResponseEntity<?> getAllWithPriceCondition(
            @RequestParam(name = "price", required = true) Double price,
            @RequestParam(name = "condition", required = true) String condition
    ) {
        return ResponseEntity.ok(BaseResponse.success(productService.getAllWithPriceConditionMybatis(price, condition)));
    }

    @GetMapping("/price-range")
    public ResponseEntity<?> getAllWithPriceRange(
            @RequestParam(name = "min-price", required = false, defaultValue = "0") Double minPrice,
            @RequestParam(name = "max-price", required = false, defaultValue = Double.MAX_VALUE + "") Double maxPrice
    ) {
        return ResponseEntity.ok(BaseResponse.success(productService.getAllWithPriceRangeMybatis(minPrice, maxPrice)));
    }

}
