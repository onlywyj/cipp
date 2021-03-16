package com.wyj.cipp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MarketModel {

    private String id;
    private String img;
    private String username;
    @NotBlank(message = "不能为空")
    private String title;
    private String info;
    @Min(value = 0,message = "价格必须大于0")
    private String price;
    @NotBlank(message = "请登录")
    private String session;
    @NotBlank(message = "必须填联系方式")
    private String contact;
    @NotBlank(message = "必须填交易地点")
    private String trading;
    private String time;
    private String sold;
    private String content;
    private String show;
    private String name;
    private String userImg;


}
