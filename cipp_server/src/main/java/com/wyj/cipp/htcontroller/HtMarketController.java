package com.wyj.cipp.htcontroller;

import com.wyj.cipp.service.HtMarketService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/v1/private")
public class HtMarketController {

    @Resource
    private HtMarketService htMarketService;

    @GetMapping("/htgetMarket")
    public Map getMarket(@RequestParam("session") String session){
        Map map = htMarketService.getMarket(session);
        return map;
    }

    @GetMapping("/htdelMarket")
    public Map delMarket(@RequestParam("session") String session,
                           @RequestParam("id") String id){
        Map map = htMarketService.delMarket(session,id);
        return  map;
    }

}
