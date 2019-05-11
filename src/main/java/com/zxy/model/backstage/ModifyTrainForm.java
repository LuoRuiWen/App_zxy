package com.zxy.model.backstage;

import lombok.Data;

import java.util.List;

@Data
public class ModifyTrainForm {
    private String tid;

    private String tname;
    //总票数
    private Integer num;

    private List<TrainStopListForm> stops;
}
