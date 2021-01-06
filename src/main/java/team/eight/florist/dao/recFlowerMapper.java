package team.eight.florist.dao;

import team.eight.florist.pojo.Users;
import team.eight.florist.pojo.recFlower;

import java.util.List;

public interface recFlowerMapper {
    int deleteByPrimaryKey(String id);

    int insert(recFlower record);

    recFlower selectByPrimaryKey(String id);

    List<Users> selectAll();

    int updateByPrimaryKey(recFlower record);

}