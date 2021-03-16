package com.wyj.cipp.service;

import java.util.Map;

public interface HtMarketService {
    public Map getMarket(String session);

    public Map delMarket(String session,String id);
}
