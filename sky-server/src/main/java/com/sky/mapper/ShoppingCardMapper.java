package com.sky.mapper;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCardMapper {

    List<ShoppingCart> list(ShoppingCartDTO shoppingCartDTO);

    @Update("update shopping_cart set number =#{number} where id=#{id}")
    void update(ShoppingCart shoppingCart);

    void list(ShoppingCart shoppingCart);
}
