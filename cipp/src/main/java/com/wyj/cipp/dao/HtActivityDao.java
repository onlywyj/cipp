package com.wyj.cipp.dao;

import com.wyj.cipp.model.ActivityModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HtActivityDao {


    @Select("SELECT\n" +
            "\ta.id,\n" +
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
            "\ta.page_views AS 'show',\n" +
            "\ta.likes AS good,\n" +
            "\ta.type AS type,\n" +
            "\ta.release_time AS time \n" +
            "FROM\n" +
            "\tactivity a")
    List<ActivityModel> getActivity();

    //查询出几条记录
    @Select("SELECT COUNT(id) FROM activity")
    Integer countActivity();

    @Delete("DELETE FROM activity WHERE id=#{id}")
    Integer delActivity(@Param("id") String id);

}
