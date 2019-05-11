package com.zxy.service.train.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.dao.stop.StopMapper;
import com.zxy.dao.train.TrainMapper;
import com.zxy.entity.stop.Stop;
import com.zxy.entity.train.Train;
import com.zxy.exception.ServiceException;
import com.zxy.model.backstage.*;
import com.zxy.service.train.BackstageTrainService;
import com.zxy.utils.IdUtils;
import com.zxy.utils.ResultData;
import com.zxy.utils.ResultPage;
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
            }else if(i>0&&stop.getPrice()==null){
                return ResultData.error(501,"不是首站票价不能为空！");
            }
            if(i<stopsForms.size()-1&&stop.getAwayTime()==null){
                return ResultData.error(501,"不是末站发车时间不能为空！");
            }
            if(i>0&&i<stopsForms.size()-1&&stop.getAwayTime().getTime()<stop.getArriveTime().getTime()){
                return ResultData.error(501,"第"+(i+1)+"站发车时间不能小于抵达时间！");
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


    public ResultData trainList(QueryTrainListForm form){
        try {
            Page page = new Page();
            page.setCurrent(form.getCurrentPage());
            page.setSize(form.getPageSize());
            List<QueryTrainListResultForm> trains = trainMapper.findByArriveTime(new Date(), page);
            ResultPage resultPage = new ResultPage();
            resultPage.setList(trains);
            resultPage.setTotal(page.getTotal());
            return ResultData.ok(resultPage);
        }catch (ServiceException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException("查询列车列表出错",e);
        }
    }

    public ResultData deleteTrain(String id){
        try{
            trainMapper.deleteByPrimaryKey(id);
            stopMapper.deleteByTrain(id);
            return ResultData.ok();
        }catch (ServiceException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException("删除车次出错！",e);
        }
    }

    public ResultData trainDetail(String id){
        QueryTrainDetailResultForm trainDetail = trainMapper.trainDetail(id);
        return ResultData.ok(trainDetail);
    }

    public ResultData modifyStops(ModifyTrainForm form){
        try {
            List<TrainStopListForm> stopForms = form.getStops();
            List<Stop> stops = new ArrayList<>();
            for (TrainStopListForm stopForm : stopForms) {
                Stop stop = new Stop();
                BeanUtils.copyProperties(stopForm, stop);
                stops.add(stop);
            }
            int result = stopMapper.alterStops(stops);
            return ResultData.ok(result);
        }catch(ServiceException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException("修改失败！",e);
        }
    }
}
