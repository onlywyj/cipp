package com.wyj.cipp.controller;


import com.wyj.cipp.model.CommentModel;
import com.wyj.cipp.model.MarketModel;
import com.wyj.cipp.service.MarketService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

//二手市场
@RestController
@RequestMapping("/v1/private")
public class MarketController {

    @Resource
    private MarketService marketService;

    @PostMapping("/marketInfoSub")
    public Map insertMarketInfo(@Validated @RequestBody MarketModel market, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return com.wyj.cipp.utils.ErrorResult.getFieldErrors(bindingResult);
        }
        Map map = marketService.insertMarketInfo(market);
        return map;
    }

    //得到列表
    @GetMapping("/marketInfoList")
    public Map getMarketList(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
        Map map = marketService.getMarketList(page);
        return map;
    }

    //自己发布的
    @GetMapping("/myMarketInfo")
    public Map getMyMarketInfo(@RequestParam("session") String session,
                               @RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
        Map map = marketService.getMyMarketInfo(session,page);
        return map;
    }

    //删除自己的发布
    @GetMapping("/delMarketInfo")
    public Map delMarketInfo(@RequestParam("id") String id,
                             @RequestParam("session") String session){
        Map map = marketService.delMarketInfo(id, session);
        return map;
    }

    //查看详细物品信息
    @GetMapping("/marketInfo")
    public Map getMarketInfo(@RequestParam("id") String id){
        Map map = marketService.getMarketInfo(id);
        return map;
    }

    //设置物品已卖出
    @GetMapping("/sell")
    public Map updateMarket(@RequestParam("session") String session,
                            @RequestParam("id") String id){
        Map map = marketService.updateMarket(session, id);
        return map;
    }

    //插入评论
    @PostMapping("/insertMarketComment")
    public Map insertComment(@Validated @RequestBody CommentModel comment, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return com.wyj.cipp.utils.ErrorResult.getFieldErrors(bindingResult);
        }
        Map map = marketService.insertComment(comment);
        return map;
    }

}



