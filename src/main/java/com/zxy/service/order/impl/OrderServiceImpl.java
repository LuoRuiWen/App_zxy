package com.zxy.service.order.impl;

import com.zxy.dao.order.OrderMapper;
import com.zxy.dao.stop.StopMapper;
import com.zxy.dao.train.TrainMapper;
import com.zxy.entity.order.Order;
import com.zxy.entity.order.RuleForm;
import com.zxy.entity.stop.Stop;
import com.zxy.service.order.OrderService;
import com.zxy.service.train.TicketInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    TrainMapper trainMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    StopMapper stopMapper;

    @Override
    public void booking(Integer tid, BigDecimal price, String start, String end) {
        //减少票余量
        trainMapper.reduceTicket(tid);
        //添加订单
        Order order = new Order();
//        Integer uid =
        order.setTid(tid);
        order.setCreatedate(new Date());
        order.setPrice(price);
        order.setStatus("已完成");
        List<Stop> stops = stopMapper.findByTid(tid);
        for (Stop stop:stops){
            if(stop.equals(start)){
                order.setStartSid(stop.getSid());
            }else if(stop.equals(end)){
                order.setStopSid(stop.getSid());
            }
        }
    }

    @Override
    public void refund(Integer oid) {
//        orderMapper.updateByPrimaryKey(oid);
    }
}
