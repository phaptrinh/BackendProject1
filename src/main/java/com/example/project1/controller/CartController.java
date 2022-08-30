package com.example.project1.controller;

import com.example.project1.payload.request.AddItemRequest;
import com.example.project1.payload.response.BaseResponse;
import com.example.project1.service.CartItemService;
import com.example.project1.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody AddItemRequest request) {
        return ResponseEntity.ok(BaseResponse.success(cartItemService.addItem(request)));
    }

    @GetMapping
    public ResponseEntity<?> getAllByCustomerIdAndProductName(
            @RequestParam(name = "customer-id", required = true) Integer customerId,
            @RequestParam(name = "product-name", required = true) String productName,
            @RequestParam(name = "offset", required = true) Integer offset,
            @RequestParam(name = "limit", required = true) Integer limit

    ) {
        return ResponseEntity.ok(BaseResponse.success(cartItemService.getAllByCustomerIdAndProductName(customerId, productName, offset, limit)));
    }
}
