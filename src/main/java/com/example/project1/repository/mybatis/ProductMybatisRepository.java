package com.example.project1.repository.mybatis;

import com.example.project1.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMybatisRepository {
    @Select({"<script>",
            "Select * from Product where ",
            "    <if test='condition == \"EQUAL\"'>price = #{price}</if>",
            "    <if test='condition == \"GREATER_THAN\"'>price &gt; #{price}</if>",
            "    <if test='condition == \"LESS_THAN\"'>price &lt; #{price}</if>",
            "</script>"})
    @Results(value = {@Result(property = "productId", column = "PRODUCT_ID"),
            @Result(property = "productName", column = "PRODUCT_NAME"),
            @Result(property = "type", column = "TYPE"),
            @Result(property = "size", column = "SIZE")}
    )
    List<Product> getAllByPriceCondition(Double price, String condition);

    @Select("select * from product where price between #{minPrice} and #{maxPrice}")
    @Results(value = {@Result(property = "productId", column = "PRODUCT_ID"),
            @Result(property = "productName", column = "PRODUCT_NAME"),
            @Result(property = "type", column = "TYPE"),
            @Result(property = "size", column = "SIZE")}
    )
    List<Product> getAllByPriceRange(Double minPrice, Double maxPrice);
}
