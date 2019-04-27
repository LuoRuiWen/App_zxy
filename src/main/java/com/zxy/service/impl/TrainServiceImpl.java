package com.zxy.service.impl;

import com.zxy.dao.train.TrainMapper;
import com.zxy.entity.train.Train;
import com.zxy.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TrainServiceImpl implements TrainService {
    @Autowired
    TrainMapper trainMapper;

    @Override
    public List<Train> findTrainByStopName(String sname) {
        List<Train> trains = new ArrayList<>();
        trains = trainMapper.selectByStopName(sname);
        return trains;
    }


}
