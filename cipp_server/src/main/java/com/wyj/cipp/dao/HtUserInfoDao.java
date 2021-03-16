package com.wyj.cipp.dao;

import com.wyj.cipp.model.UserInfoModel;
import com.wyj.cipp.model.UserLoginModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface HtUserInfoDao {

    @Select("SELECT * FROM user_info")
    List<UserInfoModel> getUserInfo();

    //查询有多少条记录
    @Select("SELECT COUNT(id) FROM user_info")
    Integer CountUserInfo();

    Map addUserInfo(UserLoginModel userLoginModel);

    //删除账号
    @Delete("DELETE FROM user_info WHERE id = #{id}")
    Integer delUserInfo(@Param("id") String id);

    //修改密码
    @Update("UPDATE user_info SET password=#{password} WHERE id=#{id}")
    Integer updateUserInfo(@Param("id") String id,@Param("password") String field);

}
