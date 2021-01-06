package team.eight.florist.dao;

import org.apache.ibatis.annotations.Param;
import team.eight.florist.pojo.Flower;

import java.util.List;

public interface FlowerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Flower record);

    Flower selectByPrimaryKey(String id);

    List<Flower> selectAll(@Param("page") Integer page,@Param("limit") Integer limit);

    int updateByPrimaryKey(Flower record);

    List<Flower> selectSell();

    List<Flower> selectBuy();

    List<Flower> selectMoney();

    int updateBuySell(@Param("buy") double buy,@Param("sell") double sell,@Param("id") String id);

    List selectRole(String role);

    Long countFlower();

    List<Flower> selectRank();

   List<Flower> selectByName(String name);
}