package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.SearchForDao;
import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.model.MarketModel;
import com.wyj.cipp.service.SearchForService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
/**
 * 搜索service层
 */
public class SearchForServiceImpl implements SearchForService {

    @Resource
    private SearchForDao searchForDao;
    //模糊搜索
    @Override
    public List GetSearch(String types,String title, Integer yeshu) {
        ArrayList<ActivityModel> list2 = new ArrayList<ActivityModel>();
        List<MarketModel> list3 = new ArrayList<>();
        ArrayList list = new ArrayList();
        if (!com.wyj.cipp.utils.tool.isNull(title)) {
            // 0 搜索活动  1 搜索比赛  2 搜索二手物品
            title = "%"+title+"%";
            switch (types) {
                case "0":
                    list2 = (ArrayList<ActivityModel>) searchForDao.GetLatestEvents("活动", title, (yeshu - 1) * 10);
                    for (ActivityModel mo:list2) {
                        String img = mo.getImg();
                        mo.setImg(img.split(",")[0]);
                        list.add(mo);
                    }
                    break;
                case "1":
                    list2 = (ArrayList<ActivityModel>) searchForDao.GetLatestEvents("比赛", title, (yeshu - 1) * 10);
                    for (ActivityModel mo:list2) {
                        String img = mo.getImg();
                        mo.setImg(img.split(",")[0]);
                        list.add(mo);
                    }
                    break;
                case "2":
                    list3 =  searchForDao.getMarketEvents(title, (yeshu - 1) * 10);
                    for (MarketModel mo:list3) {
                        String img = mo.getImg();
                        mo.setImg(img.split(",")[0]);
                        list.add(mo);
                    }
                    break;
            }
        }
        return list;
    }
}
