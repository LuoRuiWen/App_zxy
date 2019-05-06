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

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getStartSid() {
        return startSid;
    }

    public void setStartSid(Integer startSid) {
        this.startSid = startSid;
    }

    public Integer getStopSid() {
        return stopSid;
    }

    public void setStopSid(Integer stopSid) {
        this.stopSid = stopSid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}