package team.eight.florist.dao;

import java.util.List;
import team.eight.florist.pojo.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comments record);

    Comments selectByPrimaryKey(String id);

    List<Comments> selectAll();

    int updateByPrimaryKey(Comments record);
}