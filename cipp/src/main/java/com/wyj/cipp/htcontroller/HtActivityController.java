package com.wyj.cipp.htcontroller;

import com.wyj.cipp.dao.HtActivityDao;
import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.service.HtActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HtActivityController {
    @Resource
    private HtActivityService htActivityService;
    @Resource
    private HtActivityDao htActivityDao;

    @GetMapping("/htgetActivity")
    public Map getActivity(@RequestParam("session") String session){
        Map map = htActivityService.getActivity(session);
        return map;
    }

    @GetMapping("/htdelActivity")
    public Map delActivity(@RequestParam("session") String session,
                           @RequestParam("id") String id){
        Map map = htActivityService.delActivity(session,id);
        return  map;
    }

    @GetMapping("/htActivityList")
    public String toUserList(Model model){
        List<ActivityModel> listAll = htActivityDao.getActivity();
        model.addAttribute("list",listAll);
        return "admin/activity_list";
    }

}
