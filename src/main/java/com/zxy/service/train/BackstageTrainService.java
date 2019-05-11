package com.zxy.service.train;

import com.zxy.model.backstage.AddTrainForm;
import com.zxy.model.backstage.ModifyTrainForm;
import com.zxy.model.backstage.QueryTrainListForm;
import com.zxy.utils.ResultData;

public interface BackstageTrainService {
    ResultData addTrain(AddTrainForm form);
    ResultData trainList(QueryTrainListForm form);
    ResultData deleteTrain(String id);
    ResultData trainDetail(String id);
    ResultData modifyStops(ModifyTrainForm form);
}
