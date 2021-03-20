package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.UserLoginDao;
import com.wyj.cipp.model.LoginModel;
import com.wyj.cipp.model.UserLoginModel;
import com.wyj.cipp.service.UserLoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录注册serice层
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserLoginDao userLoginDao;

    //用户注册，账号是否已经注册
    public Map InsertUserInfo(UserLoginModel userInfoModel){
        String username = cc.wx.unit.Sha256.getSHA256(userInfoModel.getName().toString());
        HashMap map = new HashMap();
        if(cc.wx.unit.tool.isNull(userLoginDao.JudgeUserName(username))){
            String userpass = cc.wx.unit.Sha256.getSHA256(userInfoModel.getPassword());
            Integer i = userLoginDao.InsertUserName(username, userpass, userInfoModel.getNickname(),userInfoModel.getName().toString());
            map.put("code",i);
            map.put("message",i>0?"注册成功":"注册失败");
        }else{
            map.put("code",0);
            map.put("message","账号已注册！");
        }
        return map;
    }

    //登录检测,登录成功更新session
    public Map UserLogin(LoginModel loginModel){
        String username = cc.wx.unit.Sha256.getSHA256(loginModel.getName());
        String userpass = cc.wx.unit.Sha256.getSHA256(loginModel.getPassword());
        HashMap map = new HashMap();
        Map userInfo = userLoginDao.UserLogin(username, userpass);
        if(!cc.wx.unit.tool.isNull(userInfo)){
            String session = cc.wx.unit.Sha256.getSHA256(username + userpass + System.currentTimeMillis());
            userLoginDao.UserUpdateSession(session, username);
            map.put("code",1);
            map.put("message","登录成功");
            map.put("session",session);
            map.put("certification",userInfo.get("certification"));
            map.put("name",userInfo.get("nickname"));
            map.put("img",userInfo.get("avatar_url"));
        }else{
            map.put("code",0);
            map.put("message","账号或密码错误");
        }
        return map;
    }

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        UserLoginService bean = context.getBean(UserLoginService.class);
     //   bean.InsertUserInfo();
    }

}
