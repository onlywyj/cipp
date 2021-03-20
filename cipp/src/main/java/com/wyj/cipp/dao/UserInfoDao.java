package com.wyj.cipp.dao;

import com.wyj.cipp.model.ActivityModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserInfoDao {

    //查询自己活发布的动或比赛
    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.event_title as title,\n" +
            "\ta.activity_location as address,\n" +
            "\ta.promotional_graphics as img,\n" +
            "\ta.page_views,\n" +
            "\ta.likes as good,\n" +
            "\ta.type,\n" +
            "\tb.nickname,\n" +
            "\tb.avatar_url as userImg \n" +
            "FROM\n" +
            "\tactivity a,\n" +
            "\tuser_info b \n" +
            "WHERE\n" +
            "\ta.event_publisher_name = b.username \n" +
            "\tAND a.event_publisher_name = #{username} \n" +
            "ORDER BY\n" +
            "\ta.id DESC")
    @Results({
            @Result(property = "name",column = "nickname"),
            @Result(property = "show",column = "page_views")})
    List<ActivityModel> getUserReleaseNews(@Param("username") String name);

    //删除自己发布的
    @Delete("DELETE FROM activity WHERE id=#{id} AND event_publisher_name = #{name} ")
    Integer delMyActivity(@Param("name") String name, @Param("id") String id);

    //删除信息下的所有评论
    @Delete("DELETE FROM comment WHERE activity_id = #{id}")
    void delActivityComment(@Param("id") String id);

    //判断是不是自己的评论
    @Select("SELECT id FROM comment WHERE activity_id = #{id} AND event_publisher_name = #{name}")
    Integer judgeComment(@Param("name") String name,@Param("id") String id);

    //删除自己的评论
    @Delete("DELETE FROM comment WHERE activity_id = #{id} AND event_publisher_name = #{name}")
    Integer delMyComment(@Param("name") String name,@Param("id") String id);

}
