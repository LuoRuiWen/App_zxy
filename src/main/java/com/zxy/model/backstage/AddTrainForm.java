package com.zxy.model.backstage;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AddTrainForm {
    private String tid;
    @NotNull(message = "列车名称不能为空！")
    private String tname;

    @NotNull(message = "列车票数不能为空")
    private Integer num;
    private List<AddStopForm> stop;
}
