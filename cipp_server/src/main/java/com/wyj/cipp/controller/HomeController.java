package com.wyj.cipp.controller;

import com.wyj.cipp.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * 首页展示数据web层
 */
@RestController
@RequestMapping("/v1/private")
public class HomeController {

    @Resource
    private HomeService homeService;
    //活动展示
    @GetMapping("/eventsGallery")
    public ArrayList GetEventsGallery(@RequestParam(value = "show") String show,
                                      @RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
        ArrayList list = (ArrayList) homeService.GetEventsGallery(show,page);
        return list;
    }

    //首页轮播图展示
    @GetMapping("/carousel")
    public ArrayList GetCarousel(){
        return homeService.GetCarousel();
    }

    //查询数据量
    @GetMapping("/count")
    public Map getCount(@RequestParam("type") String type){
        Map map = homeService.getCount(type);
        return map;
    }

    //提交认证
    @GetMapping("/certification")
    public Map insertCertification(@RequestParam("session") String session,
                                   @RequestParam("department") String department){
        Map map = homeService.insertCertification(session, department);
        return map;
    }

    //修改密码
    @GetMapping("/updatePass")
    public Map updatePssWord(@RequestParam("session") String session,
                             @RequestParam("password") String password,
                             @RequestParam("newPassword") String newPassword){

        Map map = homeService.updatePssWord(session, password, newPassword);
        return map;
    }

    //修改昵称或头像
    @GetMapping("/updateNick")
    public Map updateNick(@RequestParam("session") String session,
                          @RequestParam("filed") String filed,
                          @RequestParam("value") String value){
        Map map = homeService.updateNick(session, filed, value);
        return map;
    }

}
