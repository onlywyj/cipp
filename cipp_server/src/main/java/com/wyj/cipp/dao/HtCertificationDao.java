package com.wyj.cipp.dao;

import com.wyj.cipp.model.CertificationModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface HtCertificationDao {

    @Select("SELECT id,original_name as username,application_sector as department,agree FROM certification")
    List<CertificationModel> getCertification();

    @Select("SELECT COUNT(id) FROM certification")
    Integer countCertification();

    @Update("UPDATE certification SET agree=#{agree} WHERE id=#{id}")
    Integer certification(@Param("id") String id, @Param("agree") String agree);

    //查出申请的部门和username
    @Select("SELECT * FROM certification WHERE id=#{id}")
    Map getDepartment(@Param("id") String id);

    //修改认证
    @Update("UPDATE user_info SET certification=#{certification} WHERE original_name = #{name}")
    void updateCertification(@Param("certification") String certification,@Param("name") String name);

}
