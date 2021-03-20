package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.HtCommentDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.CommitListModel;
import com.wyj.cipp.service.HtCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HtCommentServiceImpl implements HtCommentService {
    @Resource
    private HtCommentDao htCommentDao;
    @Resource
    private SubmitInformationDao submitInformationDao;

    @Override
    public Map getComment(String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                List<CommitListModel> comment = htCommentDao.getComment();
                map.put("code",0);
                map.put("msg","查询成功");
                map.put("count",htCommentDao.countComment());
                map.put("data",comment);
            }else{
                map.put("code",2);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }

    @Override
    public Map delComment(String session, String id) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                Integer i = htCommentDao.delComment(id);
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
