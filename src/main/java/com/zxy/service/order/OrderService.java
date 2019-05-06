package com.zxy.service.order;

import com.zxy.entity.order.Order;
import com.zxy.entity.order.RuleForm;
import com.zxy.service.train.TicketInfo;

import java.math.BigDecimal;

public interface OrderService {
    void booking(Integer tid, BigDecimal price, String start, String end);

    void refund(Integer oid);
}
