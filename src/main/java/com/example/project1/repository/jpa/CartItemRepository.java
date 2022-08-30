package com.example.project1.repository.jpa;

import com.example.project1.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    Optional<CartItem> findByCartCartIdAndProductProductId(Integer cartId, Integer productId);

}
