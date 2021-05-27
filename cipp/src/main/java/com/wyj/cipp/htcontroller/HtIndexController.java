package com.wyj.cipp.htcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 设置默认访问首页
 */

@Controller
public class HtIndexController {

    @GetMapping({"/htlogin",})
    public String index(){
        return "login";
    }

    @GetMapping("/htmain")
    public String toMain(){
        return "main";
    }

    @GetMapping("/htwelcome")
    public String toWelcome(){
        return "welcome";
    }

}
