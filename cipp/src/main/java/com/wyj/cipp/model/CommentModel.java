package com.wyj.cipp.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class CommentModel {

    @Min(value = 0,message = "必须为数字")
    private String id;
    @NotEmpty(message = "评论必须有内容")
    private String comment;
    private String session;

}
