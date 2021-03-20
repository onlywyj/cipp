package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.HtCarouselDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.CarouselModel;
import com.wyj.cipp.service.HtCarouselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HtCarouselServiceImpl implements HtCarouselService {

    @Resource
    private SubmitInformationDao submitInformationDao;
    @Resource
    private HtCarouselDao htCarouselDao;
    @Override
    public Map getCarousel(String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                List<CarouselModel> carousel = htCarouselDao.getCarousel();
                map.put("code",0);
                map.put("msg","查询成功");
                map.put("count",htCarouselDao.countCarousel());
                map.put("data",carousel);
            }else{
                map.put("code",1);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }

    @Override
    public Map delCarousel(String session, String id) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                Integer i = htCarouselDao.delCarousel(id);
                map.put("code",i>0?0:1);
                map.put("msg",i>0?"删除成功":"删除失败");
            }else{
                map.put("code",1);
                map.put("msg","暂无权限");
            }
        }

        return map;
    }

    @Override
    public Map addCarousel(String img, String judUrl, String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            if(identity.get("certification").equals("管理员")){
                Integer i = htCarouselDao.addCarousel(img,judUrl);
                map.put("code",i>0?0:1);
                map.put("msg",i>0?"添加成功":"添加失败");
            }else{
                map.put("code",1);
                map.put("msg","暂无权限");
            }
        }
        return map;
    }
}
