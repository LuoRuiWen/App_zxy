package com.zxy.entity.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    //订单id
    private Integer oid;
    //用户id
    private Integer uid;
    //车次id
    private Integer tid;
    //起点站id
    private Integer startSid;
    //终点站id
    private Integer stopSid;
    //订单创建时间
    private Date createdate;
    //订单状态
    private String status;
    //订单价格
    private BigDecimal price;

}