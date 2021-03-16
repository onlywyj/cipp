package com.wyj.cipp.dao;

import com.wyj.cipp.model.CommitListModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 活动详情Dao层
 */
public interface ActivityDetailsDao {
    //查询id的所有信息
    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.event_publisher_name,\n" +
            "\ta.event_title AS title,\n" +
            "\ta.activities AS content,\n" +
            "\ta.activity_fraction AS score,\n" +
            "\ta.activity_location AS address,\n" +
            "\ta.activity_plate AS belong,\n" +
            "\ta.event_registration_start_time AS enlistStartTime,\n" +
            "\ta.event_registration_end_time AS enlistOverTime,\n" +
            "\ta.event_registration_location AS location,\n" +
            "\ta.event_start_time AS activityStartTime,\n" +
            "\ta.event_end_time AS activityOverTime,\n" +
            "\ta.activity_organizer AS unit,\n" +
            "\ta.promotional_graphics AS img,\n" +
            "\ta.page_views,\n" +
            "\ta.likes AS good,\n" +
            "\ta.release_time AS time \n" +
            "FROM\n" +
            "\tactivity a \n" +
            "WHERE\n" +
            "\tid = #{id}")
    Map GetActivityDetails(@Param("id") String id);
    //查询出用户信息
    @Select("SELECT\n" +
            "\tid,\n" +
            "\tnickname AS name,\n" +
            "\tcertification AS type,\n" +
            "\tavatar_url AS img \n" +
            "FROM\n" +
            "\tuser_info \n" +
            "WHERE\n" +
            "\tusername = #{name}")
    Map GetUserInfo(@Param("name") String name);
    //查询出评论
    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.comment_time AS time,\n" +
            "\ta.COMMENT AS content,\n" +
            "\tb.nickname AS name,\n" +
            "\tb.avatar_url AS img \n" +
            "FROM\n" +
            "\tcomment a,\n" +
            "\tuser_info b \n" +
            "WHERE\n" +
            "\ta.event_publisher_name = b.username \n" +
            "\tAND a.activity_id =${id}")
    List<CommitListModel> GetComment(@Param("id") String id);

    //浏览+1
    @Update("UPDATE activity \n" +
            "SET page_views = page_views + 1 \n" +
            "WHERE\n" +
            "\tid = #{id}")
    void updatePageViews(@Param("id") String id);

    //插入点赞
    @Insert("INSERT INTO likes(activity_id,event_publisher_name) VALUES (#{id},#{name})")
    Integer insertLike(@Param("id") String id,@Param("name") String name);

    //点赞数+1
    @Update("UPDATE activity SET likes = likes + 1 WHERE id =#{id}")
    void updateLike(@Param("id") String id);

    //点赞数-1
    @Update("UPDATE activity \n" +
            "SET likes = likes - 1 \n" +
            "WHERE\n" +
            "\tid = #{id}")
    void updateLike2(@Param("id") String id);

    //取消点赞
    @Delete("DELETE FROM likes WHERE event_publisher_name = #{name} AND activity_id = #{id}")
    Integer delLike(@Param("id") String id,@Param("name") String name);

    //查询点赞
    @Select("SELECT id FROM likes WHERE event_publisher_name = #{name} AND activity_id = #{id}")
    String getLike(@Param("id") String id,@Param("name") String name);

}
