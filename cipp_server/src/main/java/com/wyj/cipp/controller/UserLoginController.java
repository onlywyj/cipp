package com.wyj.cipp.controller;

import com.wyj.cipp.model.LoginModel;
import com.wyj.cipp.model.UserLoginModel;
import com.wyj.cipp.service.UserLoginService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 登录注册web层
 */
@RestController
@RequestMapping("/v1/private")
public class UserLoginController {

    @Resource
    private UserLoginService userLoginService;

    //用户注册
    @PostMapping("/registeredUser")
    public Map InsertUserInfo(@Validated @RequestBody UserLoginModel userLoginModel, BindingResult bindingResult){
              if(bindingResult.hasErrors()){
          return cc.wx.unit.ErrorResult.getFieldErrors(bindingResult);
        }

        Map map = userLoginService.InsertUserInfo(userLoginModel);
        return map;
    }

    //用户登录
    @PostMapping("/login")
    public Map UserLogin(@RequestBody LoginModel loginModel){
        Map map = userLoginService.UserLogin(loginModel);
        return map;
    }




}
