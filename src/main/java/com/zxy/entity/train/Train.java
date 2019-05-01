package com.zxy.entity.train;


import lombok.Data;

@Data
public class Train {
    private Integer tid;

    private String tname;
    //总票数
    private Integer num;
}