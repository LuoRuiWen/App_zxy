package com.zxy.entity.stop;

import java.math.BigDecimal;
import java.util.Date;

public class Stop {
    private Integer sid;

    private String sname;

    private Date arriveTime;

    private Date awayTime;

    private Integer tid;

    private BigDecimal price;

    private Integer level;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}