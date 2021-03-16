package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.HtMarketDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.MarketModel;
import com.wyj.cipp.service.HtMarketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HtMarketServiceImpl implements HtMarketService {

    @Resource
    private SubmitInformationDao submitInformationDao;
    @Resource
    private HtMarketDao htMarketDao;

    @Override
    public Map getMarket(String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                List<MarketModel> market = htMarketDao.getMarket();
                map.put("code",0);
                map.put("msg","查询成功");
                map.put("count",htMarketDao.countMarket());
                map.put("data",market);
            }else{
                map.put("code",1);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }

    @Override
    public Map delMarket(String session, String id) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                Integer i = htMarketDao.delMarket(id);
                map.put("code",i>0?0:1);
                map.put("msg",i>0?"删除成功":"删除失败");
            }else{
                map.put("code",1);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }
}
