package com.zxy.service.train;

import lombok.Data;

import java.io.Serializable;

@Data
public class TicketInfo implements Serializable {
    private String tid;
    private String tname;
    //总票数
    private Integer num;
    //起点站
    private String start;
    //终点站
    private String end;
    //首发时间
    private String startTime;
    //到达终点时间
    private String endTime;
    //票价
    private Double price;
}
