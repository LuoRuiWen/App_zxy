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
    public List<TicketInfo> findTrainByStopName(String start, String end) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        List<TicketInfo> list = new ArrayList<>();
        List<Train> trains = trainMapper.findAll();
        for(Train train:trains){
            TicketInfo ticketInfo = new TicketInfo();
            //获取train的信息
            BeanUtils.copyProperties(train,ticketInfo);
            //获取此站所有站点信息
            List<Stop> stops = stopMapper.findByTid(train.getTid());
            //是否存在所输入的始末站
            Integer s = 0;
            Integer e = 0;
            for(Stop stop:stops){
                if(stop.getSname().equals(start)){
                    ticketInfo.setStart(stop.getSname());
                    ticketInfo.setStartTime(dateFormat.format(stop.getAwayTime()));
                    s = stop.getLevel();
                }else if(stop.getSname().equals(end)){
                    ticketInfo.setEnd(stop.getSname());
                    ticketInfo.setEndTime(dateFormat.format(stop.getAwayTime()));
                    ticketInfo.setPrice(stop.getPrice());
                    e=stop.getLevel();
                }
            }
            if(s>0&&e>0&&s<e){
                list.add(ticketInfo);
            }
        }
        return list;
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

    @Override
    public List<TicketInfo> findByTname(String tname) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        List<TicketInfo> list = new ArrayList<>();
        List<Train> trains = trainMapper.findByTname(tname);
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

    @Override
    public List<Stop> findStops(String tid) {
        List<Stop> stops = stopMapper.findByTid(tid);

        return stops;
    }

    @Override
    public void addTicket(String tid) {
        trainMapper.addTicket(tid);
    }


}
