package com.wyj.cipp.dao;

import com.wyj.cipp.model.CommitListModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HtCommentDao {

    //查询所有评论
    @Select("SELECT\n" +
            "\tid,\n" +
            "\tactivity_id,\n" +
            "\tcomment_time AS time,\n" +
            "\tcomment AS content\n" +
            "FROM\n" +
            "\tcomment")
    List<CommitListModel> getComment();

    //查询条数
    @Select("SELECT COUNT(id) FROM comment")
    Integer countComment();

    @Delete("DELETE FROM comment WHERE id = #{id}")
    Integer delComment(@Param("id") String id);


}
