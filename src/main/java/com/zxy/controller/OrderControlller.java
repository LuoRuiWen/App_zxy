package com.zxy.controller;

import com.zxy.entity.order.Order;
import com.zxy.entity.order.RuleForm;
import com.zxy.service.order.OrderService;
import com.zxy.service.train.TicketInfo;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@RequiresGuest
@Controller
public class OrderControlller {
    OrderService orderService;

    /**
     * 订票
     * @return
     */
    @RequestMapping("/booking")
    public void booking(Integer tid, BigDecimal price,String start,String end){
        System.out.println("信息"+tid);
        orderService.booking(tid,price,start,end);

    }

    /**
     * 退票
     * @param oid
     */
    public void refund(Integer oid){
//        orderService
    }
}
