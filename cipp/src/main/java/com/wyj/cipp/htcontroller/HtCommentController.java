package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/admin")
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
