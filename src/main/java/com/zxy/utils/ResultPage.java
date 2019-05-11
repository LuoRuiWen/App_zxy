package com.zxy.utils;


import lombok.Data;

@Data
public class ResultPage<T> {
    private Long total;
    private T list;
}
