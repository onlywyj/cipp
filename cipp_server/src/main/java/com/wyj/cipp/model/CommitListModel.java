package com.wyj.cipp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CommitListModel {

    private String id;
    private  String name;
    private String time;
    private  String img;
    private String content;
    private String activity_id;

}
