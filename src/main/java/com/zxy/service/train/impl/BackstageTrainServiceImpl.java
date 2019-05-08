package com.zxy.service.train.impl;

import com.zxy.dao.stop.StopMapper;
import com.zxy.dao.train.TrainMapper;
import com.zxy.entity.stop.Stop;
import com.zxy.entity.train.Train;
import com.zxy.exception.ServiceException;
import com.zxy.model.backstage.AddStopForm;
import com.zxy.model.backstage.AddTrainForm;
import com.zxy.service.train.BackstageTrainService;
import com.zxy.utils.IdUtils;
import com.zxy.utils.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BackstageTrainServiceImpl implements BackstageTrainService {
    private Logger logger = LoggerFactory.getLogger(BackstageTrainServiceImpl.class);

    @Autowired
    private TrainMapper trainMapper;

    @Autowired
    private StopMapper stopMapper;

    public ResultData addTrain(AddTrainForm form){
        if (form.getStop()==null||form.getStop().size()<2){
            return ResultData.error(401,"列车最少有两站");
        }
        int result =0;
        String tid = IdUtils.nextId();
        List<AddStopForm> stopsForms = form.getStop();
        List<Stop> stops = new ArrayList<>();
        Train train = new Train();
        BeanUtils.copyProperties(form,train);
        train.setTid(tid);
        for(int i=0;i<stopsForms.size();i++){
            Stop stop = new Stop();
            BeanUtils.copyProperties(stopsForms.get(i),stop);
            String sid = IdUtils.nextId();
            stop.setSid(sid);
            stop.setTid(tid);
            stop.setLevel(i+1);
            if(i>0&&stop.getArriveTime()==null){
                return ResultData.error(501,"不是首站抵达时间不能为空！");
            }else if(stop.getPrice()==null){
                return ResultData.error(501,"不是首站票价不能为空！");
            }
            if(i<stopsForms.size()-1&&stop.getAwayTime()==null){
                return ResultData.error(501,"不是末站发车时间不能为空！");
            }
            if(i>0&&i<stopsForms.size()-1&&stop.getArriveTime().getTime()<stop.getAwayTime().getTime()){
                return ResultData.error(501,"发车时间不能小于抵达时间！");
            }
            if(i>0){
                if(stop.getArriveTime().getTime()<stops.get(i-1).getAwayTime().getTime()-10*60*1000){
                    return ResultData.error(501,"下一站抵达时间不能在上一站出发时间的十分钟以内！");
                }
            }
            stops.add(stop);
        }
        if(stops.size()!=0) {
            result = stopMapper.addStops(stops);
            if (result!=stops.size()){
                throw new ServiceException("新增站点失败！",-1);
            }
        }
        result = trainMapper.insert(train);
        if (result!=1){
            throw new ServiceException("新增车次失败！",-1);
        }
        return ResultData.ok(1);
    }


    public ResultData trainList(){
        return null;
    }
}
