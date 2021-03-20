package com.wyj.cipp.service.impl;

import com.wyj.cipp.dao.MarketDao;
import com.wyj.cipp.dao.SubmitInformationDao;
import com.wyj.cipp.model.CommentModel;
import com.wyj.cipp.model.MarketModel;
import com.wyj.cipp.service.MarketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketServiceImpl implements MarketService {

    @Resource
    private SubmitInformationDao submitInformationDao;
    @Resource
    private MarketDao marketDao;
    //插入信息
    @Override
    public Map insertMarketInfo(MarketModel marketModel) {
        Map map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(marketModel.getSession());
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            marketModel.setUsername(identity.get("username").toString());
            String introduction = marketModel.getInfo();
            if(cc.wx.unit.tool.isNull((Object)introduction) || cc.wx.unit.tool.isNull(introduction)){
                marketModel.setInfo("此物品暂无描述");
            }
            String content = marketModel.getContent();
            if(cc.wx.unit.tool.isNull((Object)content) || cc.wx.unit.tool.isNull(content)){
                marketModel.setInfo("此物品暂无内容");
            }
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String s = now.format(dateTimeFormatter);
            marketModel.setTime(s);
            Integer i = marketDao.insertMarketInfo(marketModel);
            map.put("code",i);
            map.put("message",i>0?"成功":"失败");
        }else{
            map.put("code",2);
            map.put("message","登录失效");
        }
        return map;
    }
    //得到列表消息
    @Override
    public Map getMarketList(Integer page) {
        HashMap map = new HashMap();
        List<MarketModel> list = marketDao.getMarketList((page-1)*20);
        map.put("code",0);
        map.put("message","暂无信息");
        if(!cc.wx.unit.tool.isNull(list) && !list.isEmpty()){
            List list2 = new ArrayList();
            map.put("code",1);
            for (MarketModel mo:list) {
                String img = mo.getImg();
                String[] imgList = img.split(",");
                mo.setImg(imgList[0]);
                list2.add(mo);
            }
            Integer count = marketDao.getCount();
            map.put("saleList",list2);
            map.put("size",count);
            map.remove("message");
        }
        return map;
    }
    //得到自己的发布
    @Override
    public Map getMyMarketInfo(String session,Integer page) {
        HashMap map = new HashMap();
        if(!cc.wx.unit.tool.isNull(session)){
            Map identity = submitInformationDao.GetIdentity(session);
            if (!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
                List<MarketModel> list = marketDao.getMyMarketInfo(identity.get("username").toString(),(page-1)*8);
                if(!cc.wx.unit.tool.isNull(list) && !list.isEmpty()){
                    map.put("code",1);
                    List list2 = new ArrayList();
                    for (MarketModel mo:list) {
                        String img = mo.getImg();
                        String[] imgList = img.split(",");
                        mo.setImg(imgList[0]);
                        list2.add(mo);
                    }
                    Integer myCount = marketDao.getMyCount(identity.get("username").toString());
                    map.put("size",myCount);
                    map.put("saleList",list2);
                }else{
                    map.put("code",2);
                    map.put("message","暂无数据");
                }
            }else{
                map.put("code",0);
                map.put("message","请先登录");
            }
        }
        return map;
    }

    //删除自己的发布
    @Override
    public Map delMarketInfo(String id,String session) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            Integer i = marketDao.delMarketInfo(id, identity.get("username").toString());
            if(i>0) marketDao.delMarketComment(id,identity.get("username").toString());
            map.put("code",i);
            map.put("message",i>0?"成功":"失败");
        }else{
            map.put("code",2);
            map.put("message","登录失效");
        }
        return map;
    }

    @Override
    public Map getMarketInfo(String id) {
        HashMap map = new HashMap();
        Map marketInfo = marketDao.getMarketInfo(id);
        if(!cc.wx.unit.tool.isNull(marketInfo) && !marketInfo.isEmpty()){
            map.put("code",1);
            String img = marketInfo.get("img").toString();
            String[] imgList = img.split(",");
            marketInfo.put("img",imgList);
            List comment = marketDao.getMarketComment(id);
            marketInfo.put("commentList",comment);
            map.put("info",marketInfo);
            marketDao.updateView(id);
        }else{
            map.put("code",0);
        }
        return map;
    }

    @Override
    public Map updateMarket(String session, String id) {
        HashMap map = new HashMap();
        Map identity = submitInformationDao.GetIdentity(session);
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            String market = marketDao.getMyMarket(identity.get("username").toString(), id);
            if(cc.wx.unit.tool.isNull((Object)market)) {
                map.put("code",4);
                map.put("message","暂无参数");
                return map;
            }
            if(market.equals("t")){
                map.put("code",3);
                map.put("message","已经卖出的物品不需再次设置");
            }else{
                Integer i = marketDao.updateMarket(identity.get("username").toString(),id);
                map.put("code",i);
                map.put("message",i>0?"成功":"失败");
            }
        }else{
            map.put("code",2);
            map.put("message","登录失效");
        }
        return map;
    }

    @Override
    public Map insertComment(CommentModel commentModel) {
        HashMap map = new HashMap();
        map.put("code",2);
        map.put("message","登录失效");
        Map identity = submitInformationDao.GetIdentity(commentModel.getSession());
        if(!cc.wx.unit.tool.isNull(identity) && !identity.isEmpty()){
            //当前评论时间
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = now.format(dateTimeFormatter);
            String username = identity.get("username").toString();
            Integer i = marketDao.insertMarketComment(commentModel,time,username);
            map.put("code",i);
            map.put("message",i>0?"成功":"失败");
        }
        return map;
    }
}
