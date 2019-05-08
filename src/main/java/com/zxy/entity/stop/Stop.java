package com.zxy.entity.stop;


import lombok.Data;

import java.util.Date;

@Data
public class Stop {
    //站点id
    private String sid;
    //站点名称
    private String sname;
    //到达时间
    private Date arriveTime;
    //离开时间
    private Date awayTime;
    //车次
    private String tid;
    //首站到本站价格
    private Double price;
    //第几站
    private Integer level;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getAwayTime() {
        return awayTime;
    }

    public void setAwayTime(Date awayTime) {
        this.awayTime = awayTime;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}