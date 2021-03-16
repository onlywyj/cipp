package com.wyj.cipp.dao;

import com.wyj.cipp.model.CarouselModel;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 轮播图dao
 */
public interface CarouselDao {
   //获取轮播图
    @Select("SELECT id,image_url as imageUrl,jump_url as jumpUrl FROM carousel")
    ArrayList<CarouselModel> GetCarousel();


}
