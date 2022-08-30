package com.example.project1;

import com.example.project1.entity.Cart;
import com.example.project1.entity.Customer;
import com.example.project1.entity.Product;
import com.example.project1.payload.request.AddItemRequest;
import com.example.project1.repository.jpa.CartItemRepository;
import com.example.project1.repository.jpa.CartRepository;
import com.example.project1.repository.jpa.CustomerRepository;
import com.example.project1.repository.jpa.ProductRepository;
import com.example.project1.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartItemService cartItemService;


    public static void main(String[] args) {
        SpringApplication.run(Project1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 11; i++) {
            customerRepository.save(
                    Customer.builder()
                            .customerName("Khach hang " + i)
                            .address("Dia chi " + i)
                            .phoneNo("Phone " + i)
                            .cart(i < 6 ? cartRepository.save(new Cart()) : null)
                            .build()
            );
        }

        for (int i = 1; i < 21; i++) {
            productRepository.save(
                    Product.builder()
                            .productName("San pham " + i)
                            .type("NaN")
                            .size("NaN")
                            .price((double) (i * 1000))
                            .build()
            );
        }

        cartItemService.addItem(AddItemRequest.builder()
                        .customerId(11)
                        .productId(16)
                        .quantity(2)
                        .build());

        cartItemService.addItem(AddItemRequest.builder()
                        .customerId(11)
                        .productId(18)
                        .quantity(1)
                        .build());

        cartItemService.addItem(AddItemRequest.builder()
                        .customerId(11)
                        .productId(19)
                        .quantity(3)
                        .build());

        cartItemService.addItem(AddItemRequest.builder()
                        .customerId(11)
                        .productId(22)
                        .quantity(3)
                        .build());

        cartItemService.addItem(AddItemRequest.builder()
                        .customerId(11)
                        .productId(21)
                        .quantity(1)
                        .build());

        cartItemService.addItem(AddItemRequest.builder()
                        .customerId(2)
                        .productId(24)
                        .quantity(1)
                        .build());

        cartItemService.addItem(AddItemRequest.builder()
                        .customerId(2)
                        .productId(26)
                        .quantity(2)
                        .build());

    }
}
