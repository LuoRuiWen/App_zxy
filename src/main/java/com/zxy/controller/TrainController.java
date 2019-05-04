package com.zxy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxy.entity.train.Train;
import com.zxy.service.train.TicketInfo;
import com.zxy.service.train.TrainService;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiresGuest
@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;

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
    public List getTrainByTime(Model model){

        return  null;
    }

    /**
     * 获取车次列表
     * @return
     */
    @RequestMapping("/homePage")
    @ResponseBody
    public String findAll(){
        JSONObject json = new JSONObject();
        List<TicketInfo> tickets = trainService.findAll();
        json.put("tickets",tickets);
        return json.toJSONString();
    }

    @RequestMapping("/index")
    public String list(){
        return "homePage";
    }
}
