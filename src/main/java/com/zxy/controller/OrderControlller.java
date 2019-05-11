package com.zxy.controller;

import com.zxy.entity.order.Order;
import com.zxy.entity.order.RuleForm;
import com.zxy.service.order.OrderService;
import com.zxy.service.train.TrainService;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RequiresGuest
@RestController
public class OrderControlller {
    @Autowired
    OrderService orderService;
    @Autowired
    TrainService trainService;

    /**
     * 查询用户所有订单信息
     * @return
     */
    @RequestMapping("/orderList")
    public List<Order> findAll(String uid){
        return orderService.findAll(uid);
    }

    /**
     * 订票
     * @return
     */
    @RequestMapping("/booking")
    public void booking(@RequestBody RuleForm ruleForm){
        System.out.println("信息"+ruleForm.getTid());
        orderService.booking(ruleForm);
    }

    /**
     * 退票
     * @param oid
     */
    @RequestMapping("/refund")
    public Boolean refund(String oid){
        Order order = orderService.findOne(oid);
        String tid = order.getTid();
        //修改订单状态
        Boolean flag = orderService.refund(oid);
        if(flag){
            trainService.addTicket(tid);
        }
        return  flag;
    }
}
