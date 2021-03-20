package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.dao.UserInfoDao;
import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;
    @Resource
    private SubmitInformationDao submitInformationDao;

    @Override
    public Map getUserReleaseNews(String session) {
        ArrayList<ActivityModel> list = new ArrayList<ActivityModel>();
        HashMap infoMap = new HashMap();
        infoMap.put("code",0);
        infoMap.put("message","登录失效");
        if (!cc.wx.unit.tool.isNull(session)){
            Map map = submitInformationDao.GetIdentity(session);
            if (!cc.wx.unit.tool.isNull(map) && !map.isEmpty()){
                list = (ArrayList<ActivityModel>) userInfoDao.getUserReleaseNews(map.get("username").toString());
                if(!cc.wx.unit.tool.isNull(list) && !list.isEmpty()){
                    ArrayList list2 = new ArrayList();
                    for (ActivityModel mo : list) {
                        String[] img =  mo.getImg().split(",");
                        mo.setImg(img[0]);
                        list2.add(mo);
                    }
                    infoMap.put("code",1);
                    infoMap.put("data",list2);
                    infoMap.remove("message");
                }else{
                    infoMap.put("code",2);
                    infoMap.put("message","暂无数据");
                }
            }
        }
        return infoMap;
    }

    @Override
    public Map delMyActivity(String session, String id) {
        Map identity = submitInformationDao.GetIdentity(session);
        HashMap map = new HashMap();
        Integer i = 0;
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            i = userInfoDao.delMyActivity(identity.get("username").toString(), id);
            if (i>0) userInfoDao.delActivityComment(id);
            map.put("code",i);
            map.put("message",i>0?"成功":"失败");
        }else{
            map.put("code",2);
            map.put("message","登录失效");
        }
        return map;
    }

    @Override
    public Map judgeComment(String session, String id) {
        Map map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        map.put("code",0);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            Integer commendId = userInfoDao.judgeComment(identity.get("username").toString(), id);
            if(!cc.wx.unit.tool.isNull(commendId)) map.put("code",1);
        }
        return map;
    }

    @Override
    public Map delMyComment(String session, String id) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        map.put("code",0);
        map.put("message","失败");
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            Integer i = userInfoDao.delMyComment(identity.get("username").toString(), id);
            if(i>0) {
                map.put("code",1);
                map.put("message","成功");
            }
        }
        return map;
    }
}
