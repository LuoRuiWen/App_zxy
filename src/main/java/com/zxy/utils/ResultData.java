package com.zxy.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultData<T> {
    private String msg;

    private Integer code;

    private T data;
    public static ResultData ok(){
        return new ResultData("",0,null);
    }

    public static ResultData ok(Object t){
        return new ResultData("",0,t);
    }

    public static ResultData error(String msg){
        return  error(ResultCode.SERVICE_ERROR,msg);
    }

    public static ResultData error(Integer code,String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }
}
