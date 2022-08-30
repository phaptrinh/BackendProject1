package com.example.project1.service.impl;

import com.example.project1.entity.Customer;
import com.example.project1.payload.request.AddCustomerRequest;
import com.example.project1.repository.jpa.CustomerRepository;
import com.example.project1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(AddCustomerRequest request) {
        return customerRepository.save(
                Customer.builder()
                        .customerName(request.getCustomerName())
                        .address(request.getAddress())
                        .phoneNo(request.getPhoneNo())
                        .build()
        );
    }
}
