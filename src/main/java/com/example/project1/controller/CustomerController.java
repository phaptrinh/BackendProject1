package com.example.project1.controller;

import com.example.project1.payload.request.AddCustomerRequest;
import com.example.project1.payload.response.BaseResponse;
import com.example.project1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody AddCustomerRequest request) {
        return ResponseEntity.ok(BaseResponse.success(customerService.addCustomer(request)));
    }
}
