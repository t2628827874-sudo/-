package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.mapper.ShoppingCardMapper;
import com.sky.service.ShoppingCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShoppingCardServiceImpl implements ShoppingCardService {
    @Autowired
    private ShoppingCardMapper shoppingCardMapper;

    public void addShoppingCard(ShoppingCartDTO shoppingCartDTO) {
        //判断当前商品是否已经在购物车存在
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO,shoppingCart);
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);
        List<ShoppingCart> list = shoppingCardMapper.list(shoppingCartDTO);
        //如果存在，只需要将数量加一
        if(list!=null && list.size()>0){
            ShoppingCart sc = list.get(0);
            sc.setNumber(sc.getNumber()+1);
            shoppingCardMapper.update(shoppingCart);
        }

        //如果不存在，加入购物车


    }
}
