package com.zxy.service.order.impl;

import com.zxy.dao.order.OrderMapper;
import com.zxy.dao.stop.StopMapper;
import com.zxy.dao.train.TrainMapper;
import com.zxy.entity.order.Order;
import com.zxy.entity.order.RuleForm;
import com.zxy.entity.stop.Stop;
import com.zxy.entity.train.Train;
import com.zxy.service.order.OrderService;
import com.zxy.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
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
                order.setStartTime(dateFormat.format(stop.getAwayTime()));
                order.setStartName(stop.getSname());
            }else if(ruleForm.getEnd().equals(stop.getSname())){
                order.setStopSid(stop.getSid());
                order.setEndTime(dateFormat.format(stop.getArriveTime()));
                order.setEndName(stop.getSname());
            }
        }
        orderMapper.insert(order);
    }

    @Override
    public Boolean refund(String oid) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        //首先查找到此订单查看订单出发时间
        Order order = orderMapper.selectByPrimaryKey(oid);
        List<Stop> stops = stopMapper.findByTid(order.getTid());
        String sid = order.getStartSid();
        String startTime = "";
        for(Stop stop:stops){
            if(sid.equals(stop.getSid())){
                startTime=dateFormat.format(stop.getAwayTime());
            }
        }
        int flag= startTime.compareTo(dateFormat.format(new Date()));
        if(flag>1){
            orderMapper.refund(oid);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> findAll(String uid) {
        List<Order> orders = orderMapper.findAll(uid);
        List<Train> trains = trainMapper.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        for(Order order:orders){
            String tid = order.getTid();
            for (Train train:trains){
                if(tid.equals(train.getTid())){
                    List<Stop> stops = stopMapper.findByTid(tid);
                    for (Stop stop:stops){
                        if(order.getStartSid().equals(stop.getSid())){
                            order.setStartName(stop.getSname());
                            order.setStartTime(dateFormat.format(stop.getAwayTime()));
                        }else if(order.getStopSid().equals(stop.getSid())){
                            String end = dateFormat.format(stop.getArriveTime());
                            order.setEndName(stop.getSname());
                            order.setEndTime(end);
                        }
                    }
                }
            }
        }

        return orders;
    }

    @Override
    public Order findOne(String oid) {
        return orderMapper.selectByPrimaryKey(oid);
    }
}
