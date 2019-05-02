package com.zxy.service.train;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TicketInfo {
    private Integer tid;
    private String tname;
    //总票数
    private Integer num;
    //起点站
    private String start;
    //终点站
    private String end;
    //首发时间
    private Date startTime;
    //到达终点时间
    private Date endTime;
    //票价
    private BigDecimal price;
}
