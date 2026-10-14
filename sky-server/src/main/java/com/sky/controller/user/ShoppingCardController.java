package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.mapper.ShoppingCardMapper;
import com.sky.result.Result;
import com.sky.service.ShoppingCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user/shoppingcard")
@Api(tags = "C端购物车接口")
public class ShoppingCardController {
    @Autowired
    private ShoppingCardService shoppingCardService;

    @PostMapping("/add")
    @ApiOperation("添加购物车")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO){
        log.info("添加购物车，商品信息为："+shoppingCartDTO);
        shoppingCardService.addShoppingCard(shoppingCartDTO);

        return Result.success();
    }

}
