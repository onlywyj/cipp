package com.wyj.cipp.service;

import java.util.Map;

public interface HtMarketCommentService {

    public Map getMarketComment(String session);

    public Map delMarketComment(String session,String id);

}
