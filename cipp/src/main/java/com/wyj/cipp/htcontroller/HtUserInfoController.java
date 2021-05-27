package com.wyj.cipp.htcontroller;

import com.wyj.cipp.dao.HtUserInfoDao;
import com.wyj.cipp.model.UserInfoModel;
import com.wyj.cipp.service.HtUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HtUserInfoController {

    @Resource
    private HtUserInfoService htUserInfoService;
    @Resource
    private HtUserInfoDao htUserInfoDao;

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

    @ResponseBody
    @PostMapping("/htlogin")
    public HashMap<String, String> login(String s){
        HashMap<String,String> map = new HashMap<>();
        map.put("resultCode","200");
        map.put("message","登录成功");
        map.put("data","/htmain");
        return map;
    }

    @GetMapping("/htUserList")
    public String toUserList(Model model){
        List<UserInfoModel> listAll = htUserInfoDao.getUserInfo();
        model.addAttribute("list",listAll);
        return "admin/user_list";
    }

}
