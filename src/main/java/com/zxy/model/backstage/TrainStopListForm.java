package com.zxy.model.backstage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TrainStopListForm {
    //站点id
    private String sid;
    //站点名称
    private String sname;
    //到达时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date arriveTime;
    //离开时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date awayTime;
    //车次
    private String tid;
    //首站到本站价格
    private Double price;
    //第几站
    private Integer level;
}
