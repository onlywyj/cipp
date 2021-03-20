package com.wyj.cipp.controller;

import com.wyj.cipp.service.ActivityDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 活动比赛详情,web层
 */
@RestController
@RequestMapping("/v1/private")
public class ActivityDetailsController {

    @Resource
    private ActivityDetailsService activityDetailsService;

    //得到活动比赛id的详细数据
    @GetMapping("/activityDetails")
    public Map GetActivityDetails(@RequestParam("id") String id,
                                  @RequestParam(value = "session",required = false,defaultValue = "") String session){
        Map map = activityDetailsService.GetActivityDetails(id,session);
        return map;
    }

    //点赞
    @GetMapping("/likeid")
    public Map updateLike(@RequestParam("id") String id,
                          @RequestParam(value = "session",required = false,defaultValue = "") String session){
        Map map = activityDetailsService.updateLike(session, id);
        return map;
    }

}
