package com.zxy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxy.entity.stop.Stop;
import com.zxy.entity.train.Train;
import com.zxy.service.train.TicketInfo;
import com.zxy.service.train.TrainService;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiresGuest
@RestController
public class TrainController {
    @Autowired
    private TrainService trainService;

    /**
     * 根据车次名查询车次列表
     * @param tname
     * @return
     */
    @RequestMapping("/findByTname")
    public List<TicketInfo> getTrainByTname(String tname){
        List<TicketInfo> tickets = trainService.findByTname(tname);
        return tickets;
    }

    /**
     * 根据始末站点查询车次
     * @return
     */
    @RequestMapping("/findBySname")
    public List<TicketInfo> getTrain(String start,String end){
        List<TicketInfo> ticketInfos = trainService.findTrainByStopName(start,end);
        return ticketInfos;
    }

    /**
     * 查询列车所有站点
     * @param tid
     * @return
     */
    @RequestMapping("/findStops")
    public List<Stop> findStops(Integer tid){
        List<Stop> stops = trainService.findStops(tid);
        return  stops;
    }

    /**
     * 停车时间修改
     */
    @RequestMapping("/changeClock")
    public void changeClock(){

    }

    /**
     * 根据时刻表查询
     * @param model
     * @return
     */
    public List getTrainByTime(Model model){

        return  null;
    }

    /**
     * 获取车次列表
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<TicketInfo> findAll(){
        List<TicketInfo> tickets = trainService.findAll();
        return tickets;
    }
}
