package com.wyj.cipp.service;

import com.wyj.cipp.model.UserLoginModel;

import java.util.Map;

public interface HtUserInfoService {

    public Map getUserInfo(String session);

    public Map addUserInfo(UserLoginModel userLoginModel);

    public Map delUserInfo(String session, String id);

    public Map updateUserInfo(String session,String id,String field);

}
