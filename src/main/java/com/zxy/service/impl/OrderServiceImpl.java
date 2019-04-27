package com.zxy.service.impl;

import com.zxy.dao.order.OrderMapper;
import com.zxy.dao.train.TrainMapper;
import com.zxy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService{
    @Autowired
    TrainMapper trainMapper;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void booking(Integer tid) {
        //减少票余量
        trainMapper.reduceTicket(tid);
        //添加订单

    }

    @Override
    public void refund(Integer oid) {
//        orderMapper.updateByPrimaryKey(oid);
    }
}
