package com.zxy.entity.train;


import lombok.Data;

@Data
public class Train {
    private String tid;

    private String tname;
    //总票数
    private Integer num;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}