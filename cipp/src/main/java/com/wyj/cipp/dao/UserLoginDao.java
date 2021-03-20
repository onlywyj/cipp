package com.wyj.cipp.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * 用户信息dao
 */
public interface UserLoginDao {

    //判断是否已有账号
    @Select("SELECT id FROM user_info WHERE username=#{name}")
    Integer JudgeUserName(@Param("name") String name);

    //插入账号密码昵称
    @Insert("INSERT INTO user_info ( username, password, session, nickname, certification, avatar_url,original_name ) \n" +
            "VALUE\n" +
            "\t( #{name}, #{password}, '0', #{nickname}, '0'," +
            " 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',#{original_name} )")
    Integer InsertUserName(@Param("name") String name,@Param("password") String password,
                           @Param("nickname") String nickname,@Param("original_name") String original_name);

    //登录
    @Select("SELECT certification,nickname,avatar_url FROM user_info WHERE username= #{name} and password = #{password} ")
    Map UserLogin(@Param("name") String name, @Param("password") String password);

    //更新session
    @Update("UPDATE user_info SET session = #{session} where username=#{name}")
    Integer UserUpdateSession(@Param("session") String session,@Param("name") String name);

    //修改密码
    @Update("UPDATE user_info SET password = #{newPassword} WHERE username=#{name} AND password=#{password}")
    Integer updatePssWord(@Param("name") String name, @Param("password") String password,
                          @Param("newPassword") String newPassword);

    @Update("UPDATE user_info SET ${filed} = #{value} WHERE username = #{name}")
    Integer updateNick(@Param("name") String name, @Param("filed") String filed, @Param("value") String value);
}
