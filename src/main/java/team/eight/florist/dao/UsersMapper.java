package team.eight.florist.dao;

import team.eight.florist.pojo.Users;

import java.util.List;

public interface UsersMapper {
    int insert(Users record);

    List<Users> selectAll();

    int deleteByPrimaryKey(String id);

    Users selectByUsername(String username);
}