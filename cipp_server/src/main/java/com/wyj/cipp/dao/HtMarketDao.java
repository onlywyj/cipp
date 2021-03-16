package com.wyj.cipp.dao;

import com.wyj.cipp.model.MarketModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HtMarketDao {

    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.picture_display AS img,\n" +
            "\ta.item_name AS title,\n" +
            "\ta.item_introduction AS info,\n" +
            "\ta.sold,\n" +
            "\ta.price,\n" +
            "\ta.contact_details AS contact,\n" +
            "\ta.trading_place AS trading,\n" +
            "\ta.time,\n" +
            "\ta.content,\n" +
            "\ta.VIEW AS 'show' \n" +
            "FROM\n" +
            "\tmarket a")
    List<MarketModel> getMarket();

    //查询有多少条
    @Select("SELECT COUNT(id) FROM market")
    Integer countMarket();

    @Delete("DELETE FROM market WHERE id=#{id}")
    Integer delMarket(String id);

}
