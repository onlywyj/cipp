package com.wyj.cipp.service;


import com.wyj.cipp.model.LoginModel;
import com.wyj.cipp.model.UserLoginModel;

import java.util.Map;

public interface UserLoginService {

    //用户注册
    public Map InsertUserInfo(UserLoginModel userInfoModel);
    //用户登录，更新session
    public Map UserLogin(LoginModel loginModel);
}
