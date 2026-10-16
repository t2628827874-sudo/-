package com.sky.task;


import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import jdk.vm.ci.meta.Local;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class Ordertask {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 处理超时订单的方法
     */
    @Scheduled(cron = "0 * * * * ? ")
    public void processTimeOrder(){
        log.info("处理超市订单的时间："+ LocalDateTime.now());
        LocalDateTime time = LocalDateTime.now().plusMinutes(-15);
        List<Orders> list = orderMapper.getByStatesAndOrderTime(Orders.PENDING_PAYMENT, time);
        if(list !=null && list.size()>0){
            for (Orders orders : list) {
                orders.setStatus(Orders.CANCELLED);
                orders.setCancelReason("订单超市，已取消");
                orders.setCancelTime(LocalDateTime.now());
                //TODO 更新数据库的信息
            }
        }
    }



}
