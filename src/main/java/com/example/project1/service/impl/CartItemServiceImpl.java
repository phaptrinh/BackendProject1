package com.example.project1.service.impl;

import com.example.project1.entity.Cart;
import com.example.project1.entity.CartItem;
import com.example.project1.entity.Customer;
import com.example.project1.entity.Product;
import com.example.project1.exception.RecordNotFoundException;
import com.example.project1.payload.dto.CartItemDto;
import com.example.project1.payload.dto.CartItemsDetailDto;
import com.example.project1.payload.request.AddItemRequest;
import com.example.project1.repository.jpa.CartItemRepository;
import com.example.project1.repository.jpa.CartRepository;
import com.example.project1.repository.jpa.CustomerRepository;
import com.example.project1.repository.jpa.ProductRepository;
import com.example.project1.repository.mybatis.CartItemMybatisRepository;
import com.example.project1.service.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Resource
    CartItemMybatisRepository cartItemMybatisRepository;

    @Override
    public CartItemDto addItem(AddItemRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(
                () -> new RecordNotFoundException("Not found customer with id " + request.getCustomerId()));

        Product product = productRepository.findById(request.getProductId()).orElseThrow(
                () -> new RecordNotFoundException("Not found product with id " + request.getProductId()));

        if (customer.getCart() == null) {
            customer.setCart(cartRepository.save(new Cart()));
            customerRepository.save(customer);
        }

        Cart cart = customer.getCart();

        CartItem cartItem = cartItemRepository.findByCartCartIdAndProductProductId(cart.getCartId(), product.getProductId())
                .orElse(CartItem.builder()
                        .cart(cart)
                        .product(product)
                        .dateAdded(new Date())
//                        .quantityWished(request.getQuantity())
//                        .totalAmount(request.getQuantity() * product.getPrice())
                        .build());
        cartItem.setQuantityWished(request.getQuantity());
        cartItem.setTotalAmount(request.getQuantity() * product.getPrice());

        return modelMapper.map(cartItemRepository.save(cartItem), CartItemDto.class);
    }

    @Override
    public CartItemsDetailDto getAllByCustomerIdAndProductName(Integer customerId, String productName, Integer offset, Integer limit) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new RecordNotFoundException("Not found customer with id " + customerId));

        Cart cart = customer.getCart();
        if (cart == null) {
            throw new RecordNotFoundException("Not found cart of this customer");
        }

        var productDtos = cartItemMybatisRepository.getCartItemsWithFilter(customerId, productName, offset, limit);

        if (productDtos.size() == 0) {
            throw new RecordNotFoundException("Not found cart item");
        }
        return CartItemsDetailDto.builder()
                .cartId(cart.getCartId())
                .products(productDtos)
                .build();

    }
}
