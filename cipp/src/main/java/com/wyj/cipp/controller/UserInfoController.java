package com.wyj.cipp.controller;

import com.wyj.cipp.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/v1/private")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;
    //查询自己发布的活动或比赛
    @GetMapping("/infoRelease")
    public Map getUserReleaseNews(@RequestParam("session") String session){
        Map map = userInfoService.getUserReleaseNews(session);
        return map;
    }

    //删除自己发布的比赛或活动
    @GetMapping("/delActivity")
    public Map delMyActivity(@RequestParam("session") String session,
                             @RequestParam("id") String id){
        Map map = userInfoService.delMyActivity(session, id);
        return map;
    }

    //判断是不是自己的评论
    @GetMapping("/judgeComment")
    public Map judgeComment(@RequestParam("session") String session,
                            @RequestParam("id") String id){
        Map map = userInfoService.judgeComment(session, id);
        return map;
    }

    //删除自己的评论
    @GetMapping("/delComment")
    public Map delMyComment(@RequestParam("session") String session,
                            @RequestParam("id") String id){
        Map map = userInfoService.delMyComment(session, id);
        return map;
    }

}
