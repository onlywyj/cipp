package com.wyj.cipp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface HomeService {

    //获取活动内容
    public List GetEventsGallery(String show,Integer page);
    //轮播图展示
    public ArrayList GetCarousel();
    //查询数据
    public Map getCount(String type);

    public Map insertCertification(String session,String department);

    public Map updatePssWord(String session,String password,String newPassword);

    public Map updateNick(String session,String filed,String value);

}
