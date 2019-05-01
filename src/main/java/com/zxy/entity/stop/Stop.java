package com.zxy.entity.stop;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Stop {
    //站点id
    private Integer sid;
    //站点名称
    private String sname;
    //到达时间
    private Date arriveTime;
    //离开时间
    private Date awayTime;
    //车次
    private Integer tid;
    //时间
    private BigDecimal price;
    //第几站
    private Integer level;
}