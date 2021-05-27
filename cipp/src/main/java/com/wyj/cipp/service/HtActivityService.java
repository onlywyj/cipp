package com.wyj.cipp.service;

import com.wyj.cipp.model.ActivityModel;

import java.util.List;
import java.util.Map;

public interface HtActivityService {

    public Map getActivity(String session);

    public Map delActivity(String session,String id);

    public List<ActivityModel> selectAll();

}
