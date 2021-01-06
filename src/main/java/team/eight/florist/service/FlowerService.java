package team.eight.florist.service;

import org.springframework.stereotype.Service;
import team.eight.florist.pojo.Result;

@Service
public interface FlowerService {
    Result selectAll(Integer page,Integer limit);

    Result add(String name,Double buy,Double sell,Double cost,Double price,String role );

    Result deleteById(String[] ids);

    Result getAll(Integer page, Integer limit);

    Result rank();

    Result selectByName(String name);
}
