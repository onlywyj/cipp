package com.wyj.cipp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * 活动表实体类
 */
public class ActivityModel {

    private Integer id;
    private String event_publisher_name;//发布人账号
    private String title;//活动名称
    private String content;//活动内容
    private Integer score;//活动加分
    private String address;//活动地点
    private String belong;//活动属于板块
    private String enlistStartTime;//活动报名开始时间
    private String enlistOverTime;//活动报名结束时间
    private String location;//活动报名地点
    private String activityStartTime;//活动开始时间
    private String activityOverTime;//活动结束时间
    private String unit;//活动承办单位
    private String img;//宣传图片,进行切割
    private Integer show;//浏览量
    private Integer good;//点赞量
    private String userImg;//用户头像
    private String name;//用户昵称
    private String time; //发布时间
    private String type;//活动还是比赛
    private String session;//登陆态

}