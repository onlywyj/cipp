package com.wyj.cipp.dao;

import com.wyj.cipp.model.CarouselModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HtCarouselDao {

    @Select("SELECT id,image_url as imageUrl,jump_url as jumpUrl FROM carousel")
    List<CarouselModel> getCarousel();

    @Select("SELECT COUNT(id) FROM carousel")
    Integer countCarousel();

    @Delete("DELETE FROM carousel WHERE id=#{id}")
    Integer delCarousel(@Param("id") String id);

    @Insert("INSERT INTO carousel(image_url,jump_url) VALUES (#{img},#{url})")
    Integer addCarousel(@Param("img") String img, @Param("url") String judUrl);

}
