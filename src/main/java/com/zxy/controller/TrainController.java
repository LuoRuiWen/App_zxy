package com.zxy.controller;

import com.zxy.entity.train.Train;
import com.zxy.service.train.TrainService;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiresGuest
@Controller
public class TrainController {
    TrainService trainService;
    /**
     * 根据站点查询车次
     * @param model
     * @return
     */
    @RequestMapping("/findBySname")
    public String getTrain(Model model){
        List<Train> trains = trainService.findTrainByStopName("大雁");
        model.addAttribute("trains",trains);
        return "";
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
    public List getTrain(Model model){

    }

}
