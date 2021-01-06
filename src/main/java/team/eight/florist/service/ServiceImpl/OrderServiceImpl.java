package team.eight.florist.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.eight.florist.dao.OrderMapper;
import team.eight.florist.pojo.Order;
import team.eight.florist.pojo.Result;
import team.eight.florist.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Result selectById(String id) {
        System.out.println(id);
        List<Order> list= orderMapper.selectById(id);
        Result result=new Result();
        result.setCode(0);
        result.setData(list);
        return result;
    }

    @Override
    public Result selectAll(Integer page,Integer limit) {
        Result result = new Result();
        page=(page-1)*limit;
        List<Order> list = orderMapper.selectAll(page,limit);
        Long count= orderMapper.countOrders();
        result.setCount(count);
        result.setData(list);
        result.setCode(0);
        return result;
    }
}
