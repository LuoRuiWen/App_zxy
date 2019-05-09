package com.zxy.controller.backstage;


import com.zxy.model.backstage.AddTrainForm;
import com.zxy.model.backstage.QueryTrainListForm;
import com.zxy.service.train.BackstageTrainService;
import com.zxy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backstage/train")
public class BackstageTrainController {
    @Autowired
    private BackstageTrainService backstageTrainService;

    @PostMapping("/train")
    public ResultData addOneTrain(@Validated @RequestBody AddTrainForm form){
        return backstageTrainService.addTrain(form);
    }

    @GetMapping("/trainList")
    public ResultData trainList(QueryTrainListForm form){
        return backstageTrainService.trainList(form);
    }

    @DeleteMapping("/train/{trainId}")
    public ResultData deleteTrain(@PathVariable String trainId){
        return backstageTrainService.deleteTrain(trainId);
    }

    @GetMapping("/train/{tid}")
    public ResultData trainDetail(@PathVariable String tid){
        return backstageTrainService.trainDetail(tid);
    }
}
