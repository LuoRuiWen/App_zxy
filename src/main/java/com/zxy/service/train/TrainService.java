package com.zxy.service.train;

import com.zxy.entity.stop.Stop;
import com.zxy.entity.train.Train;

import java.util.List;

public interface TrainService {

    List<TicketInfo> findTrainByStopName(String start,String end);

    void changeClock();

    List<TicketInfo> findAll();

    List<TicketInfo> findByTname(String tname);

    List<Stop> findStops(String tid);
}
