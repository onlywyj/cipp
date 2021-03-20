package com.wyj.cipp.service;

import java.util.Map;

public interface UserInfoService {

    public Map getUserReleaseNews(String session);

    public Map delMyActivity(String session,String id);

    public Map judgeComment(String session,String id);

    public Map delMyComment(String session,String id);


}
