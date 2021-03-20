package com.wyj.cipp.service;

import java.util.Map;

public interface HtCarouselService {

    public Map getCarousel(String session);

    public Map delCarousel( String session,String id);

    public Map addCarousel(String img,String judUrl,String session);
}
