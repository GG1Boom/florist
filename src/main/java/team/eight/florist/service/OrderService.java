package team.eight.florist.service;

import org.springframework.stereotype.Service;
import team.eight.florist.pojo.Result;

@Service
public interface OrderService {
    Result selectById(String id);

    Result selectAll(Integer page,Integer limit);
}
