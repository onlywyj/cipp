package com.wyj.cipp.dao;

import com.wyj.cipp.model.CommitListModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HtMarketCommentDao {

    @Select("SELECT\n" +
            "\tid,\n" +
            "\tactivity_id,\n" +
            "\tcomment_time AS time,\n" +
            "\tcomment AS content\n" +
            "FROM\n" +
            "\tmarket_comment")
    List<CommitListModel> getMarketComment();

    @Select("SELECT COUNT(id) FROM market_comment")
    Integer countMarketComment();

    @Delete("DELETE FROM market_comment WHERE id=#{id}")
    Integer delMarketComment(@Param("id") String id);

}
