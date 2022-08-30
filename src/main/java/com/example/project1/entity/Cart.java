package com.example.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Integer cartId;

    @OneToOne(mappedBy = "cart")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private Set<CartItem> cartItems;

}
