package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/v1/private")
public class HtCommentController {

    @Resource
    private HtCommentService htCommentService;

    @GetMapping("/htgetComment")
    public Map getComment(@RequestParam("session") String session){
        Map map = htCommentService.getComment(session);
        return map;
    }

    @GetMapping("/htdelComment")
    public Map delComment(@RequestParam("session") String session,
                          @RequestParam("id") String id){
        Map map = htCommentService.delComment(session, id);
        return map;
    }

}
