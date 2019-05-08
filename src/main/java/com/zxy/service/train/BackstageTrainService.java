package com.zxy.service.train;

import com.zxy.model.backstage.AddTrainForm;
import com.zxy.utils.ResultData;

public interface BackstageTrainService {
    ResultData addTrain(AddTrainForm form);
}
