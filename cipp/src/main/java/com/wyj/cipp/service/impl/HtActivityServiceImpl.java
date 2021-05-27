package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.HtActivityDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.service.HtActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HtActivityServiceImpl implements HtActivityService {

    @Resource
    private SubmitInformationDao submitInformationDao;
    @Resource
    private HtActivityDao htActivityDao;

    @Override
    public Map getActivity(String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!com.wyj.cipp.utils.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                List<ActivityModel> activity = htActivityDao.getActivity();
                List list = new ArrayList();
                for(ActivityModel mo:activity){
                    mo.setEnlistStartTime(com.wyj.cipp.utils.DateConversion.timeStamp2Date(
                            Long.parseLong(mo.getEnlistStartTime()),"yyyy-MM-dd"));
                    mo.setEnlistOverTime(com.wyj.cipp.utils.DateConversion.timeStamp2Date(
                            Long.parseLong(mo.getEnlistOverTime()),"yyyy-MM-dd"));
                    mo.setActivityStartTime(com.wyj.cipp.utils.DateConversion.timeStamp2Date(
                            Long.parseLong(mo.getActivityStartTime()),"yyyy-MM-dd"));
                    mo.setActivityOverTime(com.wyj.cipp.utils.DateConversion.timeStamp2Date(
                            Long.parseLong(mo.getActivityOverTime()),"yyyy-MM-dd"));
                    list.add(mo);
                }
                map.put("code",0);
                map.put("msg","查询成功");
                map.put("count",htActivityDao.countActivity());
                map.put("data",list);
            }else{
                map.put("code",2);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }

    @Override
    public Map delActivity(String session, String id) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!com.wyj.cipp.utils.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                Integer i = htActivityDao.delActivity(id);
                map.put("code",i>0?0:1);
                map.put("msg",i>0?"删除成功":"删除失败");
            }else{
                map.put("code",2);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }

    @Override
    public List<ActivityModel> selectAll() {
        return htActivityDao.getActivity();
    }
}
