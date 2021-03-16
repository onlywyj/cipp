package com.wyj.cipp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
/**
 * //将该标记放在属性上，如果该属性为NULL则不参与序列化
 * //如果放在类上边,那对这个类的全部属性起作用
 * //Include.Include.ALWAYS 默认
 * //Include.NON_DEFAULT 属性为默认值不序列化
 * //Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
 * //Include.NON_NULL 属性为NULL 不序列化
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * 用户表实体类
 */
public class UserLoginModel {

    private String id;

    @Min(value = 100000000,message = "账号必须为9位")
    @Max(value = 999999999,message = "账号必须为9位")
    @Digits(integer = 9,fraction = 0,message = "不能含有特殊符号")
    private Integer name;
    @Length(min = 6,max = 16,message = "密码必须为6~16位")
    private String password;
    @NotNull
    @NotEmpty(message="用户名不能为空")
    private String nickname;
    private String certification;
    private String avatar_url;

}
