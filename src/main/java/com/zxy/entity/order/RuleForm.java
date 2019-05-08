package com.zxy.entity.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RuleForm {
    private String tid;
    private String name;
    private String IdNum;
    private Boolean student;
    private Double price;
    private String start;
    private String end;
}
