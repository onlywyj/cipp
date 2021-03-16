package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtMarketCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/v1/private")
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
