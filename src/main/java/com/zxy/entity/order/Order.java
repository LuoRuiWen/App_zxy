package com.zxy.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer oid;

    private Integer uid;

    private Integer tid;

    private Integer startSid;

    private Integer stopSid;

    private Date createdate;

    private String status;

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