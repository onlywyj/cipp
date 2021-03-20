package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.ActivityDao;
import com.wyj.cipp.dao.CarouselDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.dao.UserLoginDao;
import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页数据展示service层
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    private ActivityDao activityDao;
    @Resource
    private CarouselDao carouselDao;
    @Resource
    private SubmitInformationDao submitInformationDao;
    @Resource
    private UserLoginDao userLoginDao;

    //首页活动展示
    public ArrayList GetEventsGallery(String show, Integer page) {
        ArrayList list = new ArrayList();
        if (!cc.wx.unit.tool.isNull(show)) {
            ArrayList<ActivityModel> list2 = new ArrayList<ActivityModel>();
            // 0 得到最新活动  1 得到最热活动  2 得到已结束活动  3 得到最新比赛  4 得到最热比赛  5 得到已结束比赛
            switch (show) {
                case "0":
                    list2 = (ArrayList<ActivityModel>) activityDao.GetLatestEvents("活动",(page-1)*8);
                    break;
                case "1":
                    list2 = (ArrayList<ActivityModel>) activityDao.GetHottestActivity("活动",(page-1)*8);
                    break;
                case "2":
                    list2 = (ArrayList<ActivityModel>) activityDao.GetEventEnded(System.currentTimeMillis(), "活动",(page-1)*8);
                    break;
                case "3":list2 = (ArrayList<ActivityModel>) activityDao.GetLatestEvents("比赛",(page-1)*8);
                    break;
                case "4":list2 = (ArrayList<ActivityModel>) activityDao.GetHottestActivity("比赛",(page-1)*8);
                    break;
                case "5":list2 = (ArrayList<ActivityModel>) activityDao.GetEventEnded(System.currentTimeMillis(), "比赛",(page-1)*8);
            }
            if (!cc.wx.unit.tool.isNull(list) || !list.isEmpty()) {
                for (ActivityModel mo: list2) {
                    String[] img =  mo.getImg().split(",");
                    mo.setImg(img[0]);
                    list.add(mo);
                }
            }
        }
        return list;
    }

    //首页轮播图展示
    public ArrayList GetCarousel(){
        ArrayList list = carouselDao.GetCarousel();
        return list;
    }

    public Map getCount(String type){
        Integer i = activityDao.getCount(type);
        HashMap map = new HashMap();
        map.put("code",0);
        if(!cc.wx.unit.tool.isNull(i) && i!=0){
            map.put("code",1);
            map.put("size",i);
        }
        return map;
    }

    @Override
    public Map insertCertification(String session, String department) {
        HashMap map = new HashMap();
        String name = activityDao.getOriginalName(session);
        if(!cc.wx.unit.tool.isNull((Object)name) && !cc.wx.unit.tool.isNull(name) && !cc.wx.unit.tool.isNull(department)){
            if(cc.wx.unit.tool.isNull(department)){
                map.put("code", 3);
                map.put("message","申请的部门不能为空");
                return map;
            }
            Integer i = activityDao.insertCertification(name, department);
            map.put("code",i);
            map.put("message",i>0?"等待通过":"提交失败");
        }else {
            map.put("code", 2);
            map.put("message","登录失效");
        }
        return map;
    }

    @Override
    public Map updatePssWord(String session, String password, String newPassword) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(newPassword.length()>16 || newPassword.length()<6){
            map.put("code",0);
            map.put("message","密码必须在6~16位之间");
            return map;
        }
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            String username = identity.get("username").toString();
            Integer i = userLoginDao.updatePssWord(username, cc.wx.unit.Sha256.getSHA256(password), cc.wx.unit.Sha256.getSHA256(newPassword));
            if(i>0){
                String updateSession = username+ cc.wx.unit.Sha256.getSHA256(newPassword)+System.currentTimeMillis();
                userLoginDao.UserUpdateSession(updateSession,username);
                map.put("code",1);
                map.put("message","修改成功");
            }else{
                map.put("code",2);
                map.put("message","修改失败");
            }
        }
        return map;
    }

    @Override
    public Map updateNick(String session, String filed, String value) {
        HashMap map = new HashMap();
        Integer i =0;
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(!cc.wx.unit.tool.isNull(value)) {
                if(filed.equals("title"))
                    i = userLoginDao.updateNick(identity.get("username").toString(), "nickname", value);
                if(filed.equals("img"))
                    i = userLoginDao.updateNick(identity.get("username").toString(), "avatar_url", value);
                map.put("code",i);
                map.put("message",i>0?"成功":"失败");
            }
        }
        return map;
    }
}
