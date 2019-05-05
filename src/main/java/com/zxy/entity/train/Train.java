package com.zxy.entity.train;


import lombok.Data;

@Data
public class Train {
    private Integer tid;

    private String tname;
    //总票数
    private Integer num;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
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