package com.zxy.service.train.impl;

import com.zxy.dao.stop.StopMapper;
import com.zxy.dao.train.TrainMapper;
import com.zxy.entity.stop.Stop;
import com.zxy.entity.train.Train;
import com.zxy.service.train.TicketInfo;
import com.zxy.service.train.TrainService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {
    private Logger logger;
    @Autowired
    TrainMapper trainMapper;
    @Autowired
    StopMapper stopMapper;

    @Override
    public List<Train> findTrainByStopName(String sname) {
        List<Train> trains = trainMapper.selectByStopName(sname);
        return trains;
    }

    @Override
    public void changeClock() {

    }

    @Override
    public List<TicketInfo> findAll() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        List<TicketInfo> list = new ArrayList<>();
        List<Train> trains = trainMapper.findAll();
        for(Train train:trains){
            TicketInfo ticketInfo = new TicketInfo();
            //获取train的信息
            BeanUtils.copyProperties(train,ticketInfo);
            //根据train的信息获取火车票所有站点信息
            List<Stop> stops = stopMapper.findByTid(train.getTid());
            Stop start = new Stop();
            Stop end = new Stop();
            int i = stops.size();
            for(Stop stop:stops){
                if(stop.getLevel()==1){
                    //获取起点站信息
                    start=stop;
                }else if(stop.getLevel()==i){
                    //获取终点站信息
                    end=stop;
                }
            }
            ticketInfo.setStart(start.getSname());
            ticketInfo.setStartTime(dateFormat.format(start.getAwayTime()));
            ticketInfo.setEnd(end.getSname());
            ticketInfo.setEndTime(dateFormat.format(end.getArriveTime()));
            ticketInfo.setPrice(end.getPrice());
            list.add(ticketInfo);
        }
        return list;
    }


}
