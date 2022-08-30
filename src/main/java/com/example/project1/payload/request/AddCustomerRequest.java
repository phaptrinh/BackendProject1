package com.example.project1.payload.request;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String customerName;

    private String address;

    private String phoneNo;
}
