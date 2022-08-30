package com.example.project1.service;

import com.example.project1.entity.Customer;
import com.example.project1.payload.request.AddCustomerRequest;

public interface CustomerService {
    Customer addCustomer(AddCustomerRequest request);

}
