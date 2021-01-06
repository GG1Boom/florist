package team.eight.florist.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.eight.florist.dao.FlowerMapper;
import team.eight.florist.dao.recFlowerMapper;
import team.eight.florist.pojo.Result;
import team.eight.florist.pojo.Users;
import team.eight.florist.service.MemberService;

import java.util.List;

@Service
public class MemberServicelmpl implements MemberService {

    @Autowired
    FlowerMapper flowerMapper;
    @Autowired
    recFlowerMapper RecFlowerMapper;

    @Override
    public Result floralClassfication(String role) {
        Result result = new Result();
        List list = flowerMapper.selectRole(role);
        result.setCode(0);
        result.setData(list);
        return result;

    }

    @Override
    public Result selectAll() {
        Result result = new Result();
        List<Users> list = RecFlowerMapper.selectAll();
        result.setCode(0);
        result.setData(list);
        return result;
     
    }
}
