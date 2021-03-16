package com.wyj.cipp.service;

import com.wyj.cipp.model.CommentModel;
import com.wyj.cipp.model.MarketModel;

import java.util.Map;

public interface MarketService {

    public Map insertMarketInfo(MarketModel marketModel);
    public Map getMarketList(Integer page);
    public Map getMyMarketInfo(String session,Integer page);
    public Map delMarketInfo(String id,String session);
    public Map getMarketInfo(String id);
    public Map updateMarket(String session,String id);
    public Map insertComment(CommentModel commentModel);

}
