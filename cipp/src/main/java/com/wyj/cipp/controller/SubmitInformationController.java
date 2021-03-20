package com.wyj.cipp.controller;

import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.model.CommentModel;
import com.wyj.cipp.service.SubmitInformationService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 信息提交web层
 */
@RestController
@RequestMapping("/v1/private")
public class SubmitInformationController {

    @Resource
    private SubmitInformationService submitInformationService;

    //提交活动信息或比赛信息
    @PostMapping("/activitySubmission")
    public Map InsertActivity(@RequestBody ActivityModel activityModel){
        Map map = submitInformationService.InsertActivity(activityModel);
        return map;
    }

    //提交评论
    @PostMapping("/commentSubmission")
    public Map insertComment(@Validated @RequestBody CommentModel comment, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return cc.wx.unit.ErrorResult.getFieldErrors(bindingResult);

        }
        Map map = submitInformationService.insertComment(comment);
        return map;
    }




}
