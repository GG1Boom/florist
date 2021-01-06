package team.eight.florist.dao;

import org.apache.ibatis.annotations.Param;
import team.eight.florist.pojo.Order;

import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    List<Order> selectAll(@Param("page") Integer page, @Param("limit") Integer limit);

    Long countOrders();

    List<Order> selectById(String id);
}