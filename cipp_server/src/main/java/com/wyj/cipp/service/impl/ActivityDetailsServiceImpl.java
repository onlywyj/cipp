package com.wyj.cipp.service.impl;


import com.wyj.cipp.dao.ActivityDetailsDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.CommitListModel;
import com.wyj.cipp.service.ActivityDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动详情service层
 */
@Service
public class ActivityDetailsServiceImpl implements ActivityDetailsService {

    @Resource
    private ActivityDetailsDao activityDetailsDao;
    @Resource
    private SubmitInformationDao submitInformationDao;

    @Override
    public Map GetActivityDetails(String id,String session) {
        Map map = new HashMap();
        System.out.println(id);
        if(!cc.wx.unit.tool.isNull(id)){
            map = activityDetailsDao.GetActivityDetails(id);
            activityDetailsDao.updatePageViews(id);
            if(!cc.wx.unit.tool.isNull(map) && !map.isEmpty()){
                String event_name = map.get("event_publisher_name").toString();
                map.remove("event_publisher_name");
                Map userInfo = activityDetailsDao.GetUserInfo(event_name);
                String img = map.get("img").toString();
                String[] imgList = img.split(",");
                map.put("img",imgList);
                map.put("show",map.get("page_views"));
                map.remove("page_views");
                String comment_id = map.get("id").toString();
                List<CommitListModel> commitList = activityDetailsDao.GetComment(comment_id);
                map.put("userInfo",userInfo);
                map.put("commitList",commitList);
                //对时间戳进行处理，转换为yyyy-MM-dd
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//这个是你要转成后的时间的格式
                String enlistStartTime = sdf.format(new Date((Long) map.get("enlistStartTime")));
                String enlistOverTime = sdf.format(new Date((Long) map.get("enlistOverTime")));
                String activityStartTime = sdf.format(new Date((Long) map.get("activityStartTime")));
                String activityOverTime = sdf.format(new Date((Long) map.get("activityOverTime")));
                //替换map中的value
                map.put("enlistStartTime",enlistStartTime);
                map.put("enlistOverTime",enlistOverTime);
                map.put("activityStartTime",activityStartTime);
                map.put("activityOverTime",activityOverTime);
                String like = activityDetailsDao.getLike(id, session);
                map.put("like",false);
                if(!cc.wx.unit.tool.isNull((Object)like) && !cc.wx.unit.tool.isNull(like)){
                    map.put("like",true);
                }
            }else{
                map = new HashMap();
                map.put("code",0);
                map.put("message","暂无数据");
            }
        }else {
            map.put("code",0);
            map.put("message","参数有误");
        }
        return map;
    }

    @Override
    public Map updateLike(String session, String id) {
        Map map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            String like = activityDetailsDao.getLike(id, identity.get("username").toString());
            if(cc.wx.unit.tool.isNull((Object)like) || cc.wx.unit.tool.isNull(like)){
                Integer i = activityDetailsDao.insertLike(id, identity.get("username").toString());
                if (i>0) activityDetailsDao.updateLike(id);
                map.put("code",i);
                map.put("message",i>0?"成功":"失败");
            }else{
                Integer i = activityDetailsDao.delLike(id, identity.get("username").toString());
                if (i>0) activityDetailsDao.updateLike2(id);
                map.put("code",i>0?2:0);
                map.put("message",i>0?"成功":"失败");
            }
        }else{
            map.put("code",3);
            map.put("message","请先登录");
        }
        return map;
    }

}
