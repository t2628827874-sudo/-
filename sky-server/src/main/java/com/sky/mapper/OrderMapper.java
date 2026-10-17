package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrderMapper {

    void insert(Orders orders);


    @Select("select * from orders where status=#{status} and ordet_time<#{orderTime}")
    List<Orders> getByStatesAndOrderTime(Integer status, LocalDateTime orderTime);


    Double sumByMap(HashMap map);
}
