package com.wyj.cipp.dao;

import com.wyj.cipp.model.ActivityModel;
import com.wyj.cipp.model.MarketModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 搜索dao层
 */
public interface SearchForDao {

    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.event_title as title,\n" +
            "\ta.activity_location as address,\n" +
            "\ta.promotional_graphics as img,\n" +
            "\ta.page_views,\n" +
            "\ta.likes as good,\n" +
            "\tb.nickname,\n" +
            "\tb.avatar_url as userImg \n" +
            "FROM\n" +
            "\tactivity a,\n" +
            "\tuser_info b \n" +
            "WHERE\n" +
            "\ta.event_publisher_name = b.username \n" +
            "\tAND a.type = #{type} AND \n" +
            "\ta.event_title like #{title} \n" +
            "ORDER BY\n" +
            "\ta.id DESC \n" +
            "\tLIMIT ${yeshu},10")
    @Results({
            @Result(property = "name",column = "nickname"),
            @Result(property = "show",column = "page_views")})
    List<ActivityModel> GetLatestEvents(@Param("type") String type,
                                        @Param("title") String title,
                                        @Param("yeshu") Integer yeshu);

@Select("SELECT\n" +
        "\ta.id,\n" +
        "\ta.picture_display AS img,\n" +
        "\ta.item_name AS title,\n" +
        "\ta.item_introduction AS info,\n" +
        "\ta.price,\n" +
        "\ta.time,\n" +
        "\ta.view as 'show',\n" +
        "\tb.avatar_url AS userImg,\n" +
        "\tb.nickname AS name \n" +
        "FROM\n" +
        "\tmarket a,\n" +
        "\tuser_info b \n" +
        "WHERE\n" +
        "\ta.event_publisher_name = b.username \n" +
        "\tAND a.sold = 'f' \n" +
        "\tAND a.item_name LIKE #{title} \n" +
        "ORDER BY\n" +
        "\ta.id DESC \n" +
        "\tLIMIT ${yeshu},\n" +
        "\t10")
    List<MarketModel> getMarketEvents(@Param("title") String title,
                                      @Param("yeshu") Integer yeshu);

}
