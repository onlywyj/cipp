package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtUserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/v1/private")
public class HtUserInfoController {

    @Resource
    private HtUserInfoService htUserInfoService;

    @GetMapping("/htgetUserInfo")
    public Map getUserInfo(@RequestParam("session") String session){
        Map map = htUserInfoService.getUserInfo(session);
        return map;
    }

    @GetMapping("/htdelUserInfo")
    public Map delUserInfo(@RequestParam("session") String session,
                           @RequestParam("id") String id){
        Map map = htUserInfoService.delUserInfo(session, id);
        return map;
    }

    @GetMapping("/htupdateUserInfo")
    public Map updateUserInfo(@RequestParam("session") String session,
                              @RequestParam("id") String id,
                              @RequestParam("field") String field){
        Map map = htUserInfoService.updateUserInfo(session, id, field);
        return map;
    }



}
