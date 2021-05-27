package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.model.CommentModel;
import com.wyj.cipp.service.SubmitInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubmitInformationServiceImpl implements SubmitInformationService {

    @Resource
    private SubmitInformationDao submitInformationDao;
    @Override
    public Map InsertActivity(ActivityModel activityModel) {
        Map map = new HashMap();
        map.put("code",3);
        map.put("message","登录失效");
        if(!com.wyj.cipp.utils.tool.isNull((Object) activityModel.getSession()) && !com.wyj.cipp.utils.tool.isNull(activityModel.getSession())){
            Map identity = submitInformationDao.GetIdentity(activityModel.getSession());
            if (!com.wyj.cipp.utils.tool.isNull(identity) && !identity.isEmpty()){
                String certification = identity.get("certification").toString();
                if(!("0").equals(certification)){
                    activityModel.setEvent_publisher_name(identity.get("username").toString());
                    //当前发布时间
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String s = now.format(dateTimeFormatter);
                    activityModel.setTime(s);
                    //将yyyy-MM-dd转换为时间戳
                    String pattern = "yyyy-MM-dd";
                    Long enlistStartTime = com.wyj.cipp.utils.DateConversion.date2TimeStamp(activityModel.getEnlistStartTime()
                            +"T00:00:00",pattern);
                    Long enlistOverTime = com.wyj.cipp.utils.DateConversion.date2TimeStamp(activityModel.getEnlistOverTime()
                            +"T00:00:00",pattern);
                    Long activityStartTime = com.wyj.cipp.utils.DateConversion.date2TimeStamp(activityModel.getActivityStartTime()
                            +"T00:00:00",pattern);
                    Long activityOverTime = com.wyj.cipp.utils.DateConversion.date2TimeStamp(activityModel.getActivityOverTime()
                            +"T00:00:00",pattern);
                    activityModel.setEnlistStartTime(enlistStartTime.toString());
                    activityModel.setEnlistOverTime(enlistOverTime.toString());
                    activityModel.setActivityStartTime(activityStartTime.toString());
                    activityModel.setActivityOverTime(activityOverTime.toString());
                    Integer integer = submitInformationDao.InsertActivity(activityModel);
                    map.put("code",integer);
                    map.put("message",integer>0?"成功":"失败");
                }else{
                    map.put("code",2);
                    map.put("message","无权限");
                }
            }
        }
        return map;
    }

    @Override
    public Map insertComment(CommentModel commentModel) {
        HashMap map = new HashMap();
        map.put("code",2);
        map.put("message","登录失效");
        if (!com.wyj.cipp.utils.tool.isNull(commentModel.getSession())){
            Map identity = submitInformationDao.GetIdentity(commentModel.getSession());
            if(!com.wyj.cipp.utils.tool.isNull(identity) && !identity.isEmpty()){
                //当前评论时间
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String time = now.format(dateTimeFormatter);
                String username = identity.get("username").toString();
                Integer i = submitInformationDao.insertComment(
                        commentModel.getId(), commentModel.getComment(), time, username);
                System.out.println(i);
                map.put("code",i);
                map.put("message",i>0?"成功":"失败");
            }
        }
        return map;
    }

}
