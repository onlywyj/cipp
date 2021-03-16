package com.wyj.cipp.service;

import java.util.Map;

public interface ActivityDetailsService {

    public Map GetActivityDetails(String id,String session);

    public Map updateLike(String session,String id);

}
