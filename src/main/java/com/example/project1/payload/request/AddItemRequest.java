package com.example.project1.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemRequest {
    private Integer customerId;

    private Integer productId;

    private Integer quantity;

}
