package com.zxy.service.train;

import com.zxy.entity.train.Train;

import java.util.List;

public interface TrainService {

    List<Train> findTrainByStopName(String sname);

    void changeClock();
}
