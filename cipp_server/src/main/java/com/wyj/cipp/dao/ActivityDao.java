package com.wyj.cipp.dao;

import com.wyj.cipp.model.ActivityModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 活动比赛展示dao层
 */
public interface ActivityDao {

    //得到最新活动,利用id排序
    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.event_title as title,\n" +
            "\ta.activity_location as address,\n" +
            "\ta.promotional_graphics as img,\n" +
            "\ta.page_views,\n" +
            "\ta.likes as good,\n" +
            "\tb.nickname,\n" +
            "\tb.avatar_url as userImg \n" +
            "FROM\n" +
            "\tactivity a,\n" +
            "\tuser_info b \n" +
            "WHERE\n" +
            "\ta.event_publisher_name = b.username \n" +
            "\tAND a.type = #{type} \n" +
            "ORDER BY\n" +
            "\ta.id DESC \n" +
            "\tLIMIT ${page},8")
    @Results({
            @Result(property = "name",column = "nickname"),
            @Result(property = "show",column = "page_views")})
    List<ActivityModel> GetLatestEvents(@Param("type") String type, @Param("page") Integer page);

    //得到最热活动，利用page_views,likes排序
    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.event_title as title,\n" +
            "\ta.activity_location as address,\n" +
            "\ta.promotional_graphics as img,\n" +
            "\ta.page_views,\n" +
            "\ta.likes as good,\n" +
            "\tb.nickname,\n" +
            "\tb.avatar_url as userImg \n" +
            "FROM\n" +
            "\tactivity a,\n" +
            "\tuser_info b \n" +
            "WHERE\n" +
            "\ta.event_publisher_name = b.username \n" +
            "\tAND a.type = #{type} \n" +
            "ORDER BY\n" +
            "\tpage_views DESC,\n" +
            "\tlikes DESC \n" +
            "\tLIMIT ${page},8")
    @Results({
            @Result(property = "name",column = "nickname"),
            @Result(property = "show",column = "page_views")})
    List<ActivityModel> GetHottestActivity(@Param("type") String type,@Param("page") Integer page);

    //得到已结束活动
    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.event_title as title,\n" +
            "\ta.activity_location as address,\n" +
            "\ta.promotional_graphics as img,\n" +
            "\ta.page_views,\n" +
            "\ta.likes as good,\n" +
            "\tb.nickname,\n" +
            "\tb.avatar_url as userImg \n" +
            "FROM\n" +
            "\tactivity a,\n" +
            "\tuser_info b \n" +
            "WHERE\n" +
            "\ta.event_publisher_name = b.username \n" +
            "\tAND event_end_time < ${time} \n" +
            "\tAND a.type = #{type} \n" +
            "ORDER BY\n" +
            "\tid DESC \n" +
            "\tLIMIT ${page},8")
    @Results({
            @Result(property = "name",column = "nickname"),
            @Result(property = "show",column = "page_views")})
    List<ActivityModel> GetEventEnded(@Param("time") Long time,@Param("type") String type,@Param("page") Integer page);

    @Select("SELECT COUNT(id) FROM activity WHERE type=#{type}")
    Integer getCount(@Param("type") String type);

    //提交认证
    @Insert("INSERT INTO certification(original_name,application_sector) VALUES (#{name},#{department})")
    Integer insertCertification(@Param("name") String name,@Param("department") String department);

    //查询原账号
    @Select("SELECT original_name FROM user_info WHERE session = #{session}")
    String getOriginalName(@Param("session") String session);

}
