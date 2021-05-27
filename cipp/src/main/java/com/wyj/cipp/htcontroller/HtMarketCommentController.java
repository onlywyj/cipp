package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtMarketCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HtMarketCommentController {
    @Resource
    private HtMarketCommentService htMarketCommentService;
    @GetMapping("/htgetMarketComment")
    public Map getMarketComment(@RequestParam("session") String session){
        Map map = htMarketCommentService.getMarketComment(session);
        return map;
    }

    @GetMapping("/htdelMarketComment")
    public Map delMarketComment(@RequestParam("session") String session,
                         @RequestParam("id") String id){
        Map map = htMarketCommentService.delMarketComment(session,id);
        return  map;
    }

}
