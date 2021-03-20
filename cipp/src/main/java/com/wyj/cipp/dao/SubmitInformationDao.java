package com.wyj.cipp.dao;

import com.wyj.cipp.model.ActivityModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface SubmitInformationDao {
    //插入活动比赛数据
    @Insert("INSERT INTO activity (\n" +
            "event_publisher_name,\n" +
            "event_title,\n" +
            "activities,\n" +
            "activity_fraction,\n" +
            "activity_location,\n" +
            "activity_plate,\n" +
            "event_registration_start_time,\n" +
            "event_registration_end_time,\n" +
            "event_registration_location,\n" +
            "event_start_time,\n" +
            "event_end_time,\n" +
            "activity_organizer,\n" +
            "promotional_graphics,\n" +
            "page_views,\n" +
            "likes,\n" +
            "type,\n" +
            "release_time \n" +
            ")\n" +
            "VALUES\n" +
            "\t(\n" +
            "\t#{event_publisher_name},\n" +
            "\t#{title},\n" +
            "\t#{content},\n" +
            "\t#{score},\n" +
            "\t#{address},\n" +
            "\t#{belong},\n" +
            "\t#{enlistStartTime},\n" +
            "\t#{enlistOverTime},\n" +
            "\t#{location},\n" +
            "\t#{activityStartTime},\n" +
            "\t#{activityOverTime},\n" +
            "\t#{unit},\n" +
            "\t#{img},\n" +
            "\t0,\n" +
            "\t0,\n" +
            "\t#{type},\n" +
            "\t#{time} \n" +
            "\t)")
    Integer InsertActivity(ActivityModel activityModel);

    //先验证身份
    @Select("SELECT\n" +
            "\tusername,\n" +
            "\tcertification \n" +
            "FROM\n" +
            "\tuser_info \n" +
            "WHERE\n" +
            "\tsession = #{session}")
    Map GetIdentity(@Param("session") String session);

    @Insert("INSERT INTO comment ( activity_id, event_publisher_name, comment, comment_time ) \n" +
            "VALUE\n" +
            "\t( #{id}, #{name}, #{comment}, #{comment_time} )")
    Integer insertComment(@Param("id") String id,@Param("comment") String comment,
                          @Param("comment_time") String comment_time,@Param("name") String name);


}
