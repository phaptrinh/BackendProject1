package com.example.project1.service;

import com.example.project1.payload.dto.CartItemDto;
import com.example.project1.payload.request.AddItemRequest;

public interface CartItemService {
    CartItemDto addItem(AddItemRequest request);

    Object getAllByCustomerIdAndProductName(Integer customerId, String productName, Integer offset, Integer limit);

}
