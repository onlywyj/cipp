package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtActivityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/v1/private")
public class HtActivityController {
    @Resource
    private HtActivityService htActivityService;

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

}
