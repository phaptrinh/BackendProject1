package com.example.project1.payload.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.text.DateFormat;
import java.util.Date;

@Data
public class CartItemDto {
    private Integer id;

    private Integer cartId;

    private Integer productId;

    private String productName;

    private Integer quantityWished;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss dd-MM-yyyy")
    private Date dateAdded;

    private Double totalAmount;
}
