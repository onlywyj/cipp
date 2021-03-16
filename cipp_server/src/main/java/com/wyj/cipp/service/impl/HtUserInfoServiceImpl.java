package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.HtUserInfoDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.UserInfoModel;
import com.wyj.cipp.model.UserLoginModel;
import com.wyj.cipp.service.HtUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HtUserInfoServiceImpl implements HtUserInfoService {
    @Resource
    private HtUserInfoDao htUserInfoDao;
    @Resource
    private SubmitInformationDao submitInformationDao;
    @Override
    public Map getUserInfo(String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                List<UserInfoModel> userInfo = htUserInfoDao.getUserInfo();
                map.put("code",0);
                map.put("msg","查询成功");
                map.put("count",htUserInfoDao.CountUserInfo());
                map.put("data",userInfo);
            }else{
                map.put("code",2);
                map.put("msg","无权限");
            }
        }
        return map;
    }

    @Override
    public Map addUserInfo(UserLoginModel userLoginModel) {
        return null;
    }

    @Override
    public Map delUserInfo(String session, String id) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                Integer i = htUserInfoDao.delUserInfo(id);
                map.put("code",i>0?0:1);
                map.put("msg",i>0?"删除成功":"删除失败");
            }else{
                map.put("code",2);
                map.put("msg","无权限");
            }
        }
        return map;
    }

    @Override
    public Map updateUserInfo(String session, String id, String field) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                String s = cc.wx.unit.Sha256.getSHA256(field);
                Integer i = htUserInfoDao.updateUserInfo(id, s);
                map.put("code",i>0?0:1);
                map.put("msg",i>0?"修改成功":"修改失败");
            }else{
                map.put("code",2);
                map.put("msg","无权限");
            }
        }
        return map;
    }
}
