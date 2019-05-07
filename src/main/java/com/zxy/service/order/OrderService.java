package com.zxy.service.order;

import com.zxy.entity.order.Order;
import com.zxy.entity.order.RuleForm;
import com.zxy.service.train.TicketInfo;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    void booking(RuleForm ruleForm);

    Boolean refund(String oid);

    List<Order> findAll(String uid);
}
