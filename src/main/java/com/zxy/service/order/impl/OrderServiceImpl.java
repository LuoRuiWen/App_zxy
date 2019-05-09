package com.zxy.service.order.impl;

import com.zxy.dao.order.OrderMapper;
import com.zxy.dao.stop.StopMapper;
import com.zxy.dao.train.TrainMapper;
import com.zxy.entity.order.Order;
import com.zxy.entity.order.RuleForm;
import com.zxy.entity.stop.Stop;
import com.zxy.service.order.OrderService;
import com.zxy.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void booking(RuleForm ruleForm) {
        //减少票余量
        trainMapper.reduceTicket(ruleForm.getTid());
        //添加订单
        Order order = new Order();
        String id = IdUtils.nextId();
        order.setOid(id);
        order.setTid(ruleForm.getTid());
        order.setUid(ruleForm.getUid());
        order.setCreatedate(new Date());
        if(ruleForm.getStudent()){
            Double price = ruleForm.getPrice()*0.9;
            order.setPrice(price);
        }else{
            order.setPrice(ruleForm.getPrice());
        }
        order.setStatus("购买成功");
        List<Stop> stops = stopMapper.findByTid(ruleForm.getTid());
        for (Stop stop:stops){
            if(ruleForm.getStart().equals(stop.getSname())){
                order.setStartSid(stop.getSid());
                order.setStartTime(stop.getAwayTime());
                order.setStartName(stop.getSname());
            }else if(ruleForm.getEnd().equals(stop.getSname())){
                order.setStopSid(stop.getSid());
                order.setEndTime(stop.getArriveTime());
                order.setEndName(stop.getSname());
            }
        }
        orderMapper.insert(order);
    }

    @Override
    public Boolean refund(String oid) {
        //首先查找到此订单查看订单出发时间
        Order order = orderMapper.selectByPrimaryKey(oid);
        int flag= order.getStartTime().compareTo(new Date());
        if(flag>1){
            orderMapper.refund(oid);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> findAll(String uid) {
        return orderMapper.findAll(uid);
    }

    @Override
    public Order findOne(String oid) {
        return orderMapper.selectByPrimaryKey(oid);
    }
}
