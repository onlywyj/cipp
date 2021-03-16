package com.wyj.cipp.dao;

import com.wyj.cipp.model.CommentModel;
import com.wyj.cipp.model.CommitListModel;
import com.wyj.cipp.model.MarketModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MarketDao {
    @Insert("INSERT INTO market ( event_publisher_name, picture_display, item_name, item_introduction, sold, " +
            "contact_details, trading_place, price,time,content )\n" +
            "VALUES\n" +
            "\t( #{username}, #{img}, #{title}, #{info}, 'f', #{contact}, #{trading}, #{price}, #{time},#{content} )")
    Integer insertMarketInfo(MarketModel marketModel);

    @Select("SELECT id,picture_display as img,item_name as title, item_introduction as info," +
            "price FROM market WHERE sold='f' ORDER BY id DESC LIMIT ${page},20")
    List<MarketModel> getMarketList(@Param("page") Integer page);

    @Select("SELECT id,picture_display as img,item_name as title, item_introduction as info," +
            "price,sold FROM market WHERE event_publisher_name = #{name} ORDER BY id DESC LIMIT ${page},8 ")
    List<MarketModel> getMyMarketInfo(@Param("name") String name,@Param("page") Integer page);

    @Delete("DELETE FROM market WHERE id = #{id} AND event_publisher_name =#{name}")
    Integer delMarketInfo(@Param("id") String id,@Param("name") String name);

    //删除所有评论
    @Delete("DELETE FROM market_comment WHERE id = #{id} AND event_publisher_name =#{name}")
    void delMarketComment(@Param("id") String id,@Param("name")  String name);

    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.picture_display AS img,\n" +
            "\ta.item_name AS title,\n" +
            "\ta.item_introduction AS info,\n" +
            "\ta.price,\n" +
            "\ta.contact_details as contact,\n" +
            "\ta.trading_place as trading,\n" +
            "\ta.view as 'show',\n" +
            "\tb.avatar_url as useImg,\n" +
            "\tb.nickname as name, \n" +
            "\tb.certification as rz \n" +
            "FROM\n" +
            "\tmarket a,\n" +
            "\tuser_info b \n" +
            "WHERE\n" +
            "\ta.id = #{id} \n" +
            "\tAND a.event_publisher_name = b.username")
    Map getMarketInfo(@Param("id") String id);

    //查询评论
    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.comment as content,\n" +
            "\ta.comment_time AS time,\n" +
            "\tb.nickname AS name,\n" +
            "\tb.avatar_url AS img \n" +
            "FROM\n" +
            "\tmarket_comment a,\n" +
            "\tuser_info b \n" +
            "WHERE\n" +
            "\ta.activity_id = #{id} \n" +
            "\tAND a.event_publisher_name = b.username")
    List<CommitListModel> getMarketComment(@Param("id") String id);

    //浏览量+1
    @Update("UPDATE market SET view=view+1 WHERE id = #{id}")
    void updateView(@Param("id") String id);

    //插入评论
    @Insert("INSERT INTO market_comment ( activity_id, event_publisher_name, comment, comment_time )\n" +
            "VALUES\n" +
            "\t( #{id}, #{name}, #{comment}, #{time} )")
    Integer insertMarketComment(CommentModel commentModel,
                                @Param("time") String time,
                                @Param("name") String name);

    //查询多少条数据
    @Select("SELECT COUNT(ID) FROM market WHERE sold='f'")
    Integer getCount();

    //查询自己有多少条数据
    @Select("SELECT COUNT(ID) FROM market WHERE event_publisher_name = #{name}")
    Integer getMyCount(@Param("name") String name);

    //设置已卖出
    @Update("UPDATE market SET sold = 't' WHERE event_publisher_name = #{name} AND id = #{id} ")
    Integer updateMarket(@Param("name") String name, @Param("id") String id);

    //查询有没有卖出
    @Select("SELECT sold FROM market WHERE event_publisher_name = #{name} AND id = #{id} ")
    String getMyMarket(@Param("name") String name, @Param("id") String id);
}
