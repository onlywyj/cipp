package com.wyj.cipp.htcontroller;

import com.wyj.cipp.dao.HtMarketDao;
import com.wyj.cipp.model.MarketModel;
import com.wyj.cipp.service.HtMarketService;
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
public class HtMarketController {

    @Resource
    private HtMarketService htMarketService;
    @Resource
    private HtMarketDao htMarketDao;

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


    @GetMapping("/htMarketList")
    public String toUserList(Model model){
        List<MarketModel> listAll = htMarketDao.getMarket();
        model.addAttribute("list",listAll);
        return "admin/market_list";
    }
}
