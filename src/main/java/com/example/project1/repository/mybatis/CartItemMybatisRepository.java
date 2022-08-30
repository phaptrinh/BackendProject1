package com.example.project1.repository.mybatis;

import com.example.project1.payload.dto.CartItemDto;
import com.example.project1.payload.dto.CartItemsDetailDto;
import com.example.project1.payload.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartItemMybatisRepository {

    @Select("SELECT * "
            + "FROM "
            + "CART_ITEM CI JOIN PRODUCT P ON CI.PRODUCT_ID = P.PRODUCT_ID  JOIN CUSTOMER C ON C.CART_ID = CI.CART_ID "
            + "WHERE CUSTOMER_ID = #{customerId} "
            + "AND PRODUCT_NAME LIKE '%' || #{productName} || '%' "
//            + "ORDER BY ID "
            + "LIMIT #{limit} OFFSET #{offset}")
    @Results(value = {
//            @Result(property = "cartId", column = "CART_ID"),
            @Result(property = "productId", column = "PRODUCT_ID"),
            @Result(property = "productName", column = "PRODUCT_NAME"),
            @Result(property = "quantityWished", column = "QUANTITY_WISHED"),
            @Result(property = "totalAmount", column = "TOTAL_AMOUNT"),
            @Result(property = "dateAdded", column = "DATE_ADDED"),
    })
    List<ProductDto> getCartItemsWithFilter(Integer customerId, String productName, Integer offset, Integer limit);

}
