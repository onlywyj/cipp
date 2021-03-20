package com.wyj.cipp.service;

import java.util.Map;

public interface HtActivityService {

    public Map getActivity(String session);

    public Map delActivity(String session,String id);

}
