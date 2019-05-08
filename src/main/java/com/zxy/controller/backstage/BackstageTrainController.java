package com.zxy.controller.backstage;


import com.zxy.model.backstage.AddTrainForm;
import com.zxy.service.train.BackstageTrainService;
import com.zxy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backstage/train")
public class BackstageTrainController {
    @Autowired
    private BackstageTrainService backstageTrainService;

    @PostMapping("/train")
    public ResultData addOneTrain(@RequestBody AddTrainForm form){
        return backstageTrainService.addTrain(form);
    }
}
