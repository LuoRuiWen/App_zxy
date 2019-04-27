package com.zxy.controller;

import com.zxy.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequiresGuest
@Controller
public class OrderControlller {
    OrderService orderService;


    /**
     * 订票
     * @return
     */
    @RequestMapping("/booking")
    public String booking(Integer tid){
        orderService.booking(tid);

        return "";
    }

    /**
     * 退票
     * @param oid
     */
    public void refund(Integer oid){
//        orderService
    }
}
