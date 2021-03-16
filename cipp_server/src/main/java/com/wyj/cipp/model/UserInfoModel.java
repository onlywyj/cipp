package com.wyj.cipp.model;

import lombok.Data;

@Data
public class UserInfoModel {

    private String id;
    private String username;
    private String password;
    private String nickname;
    private String certification;
    private String avatar_url;
    private String original_name;

}
