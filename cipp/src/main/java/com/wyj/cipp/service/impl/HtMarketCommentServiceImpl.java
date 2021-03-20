package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.HtMarketCommentDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.CommitListModel;
import com.wyj.cipp.service.HtMarketCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HtMarketCommentServiceImpl implements HtMarketCommentService {
    @Resource
    private SubmitInformationDao submitInformationDao;
    @Resource
    private HtMarketCommentDao htMarketCommentDao;

    @Override
    public Map getMarketComment(String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                List<CommitListModel> marketComment = htMarketCommentDao.getMarketComment();
                map.put("code",0);
                map.put("msg","查询成功");
                map.put("count",htMarketCommentDao.countMarketComment());
                map.put("data",marketComment);
            }else{
                map.put("code",2);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }

    @Override
    public Map delMarketComment(String session, String id) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                Integer i = htMarketCommentDao.delMarketComment(id);
                map.put("code",i>0?0:1);
                map.put("msg",i>0?"删除成功":"删除失败");
            }else{
                map.put("code",2);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }
}
