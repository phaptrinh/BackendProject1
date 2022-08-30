package com.example.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Integer productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private Double price;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    Set<CartItem> cartItems;

}
