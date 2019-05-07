package com.zxy.controller;

import com.zxy.entity.order.Order;
import com.zxy.entity.order.RuleForm;
import com.zxy.service.order.OrderService;
import com.zxy.service.train.TicketInfo;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@RequiresGuest
@Controller
public class OrderControlller {
    @Autowired
    OrderService orderService;

    /**
     * 查询用户所有订单信息
     * @return
     */
    public List<Order> findAll(String uid){
        return orderService.findAll(uid);
    }

    /**
     * 订票
     * @return
     */
    @RequestMapping("/booking")
    public void booking(RuleForm ruleForm){
        System.out.println("信息"+ruleForm.getTid());
        orderService.booking(ruleForm);

    }

    /**
     * 退票
     * @param oid
     */
    @RequestMapping("/refund")
    public Boolean refund(String oid){
        Boolean flag = orderService.refund(oid);
        return flag;
    }
}
