package com.wyj.cipp.controller;

import com.wyj.cipp.service.SearchForService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 搜索web层
 */
@RestController
@RequestMapping("/v1/private")
public class SearchForController {

    @Resource
    private SearchForService searchForService;
    //搜索窗口
    @GetMapping("/search")
    public List GetSearch(@RequestParam("typesof") String typesof,
                          @RequestParam("title") String title,
                          @RequestParam(value = "yeshu",required = false, defaultValue = "1") Integer yeshu){
        List list = searchForService.GetSearch(typesof, title, yeshu);
        return list;
    }
}
