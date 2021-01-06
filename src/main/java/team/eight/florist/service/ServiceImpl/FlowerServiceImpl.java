package team.eight.florist.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import team.eight.florist.dao.FlowerMapper;
import team.eight.florist.pojo.Flower;
import team.eight.florist.pojo.Result;
import team.eight.florist.service.FlowerService;

import java.util.List;
import java.util.UUID;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerMapper flowerMapper;

    @Override
    public Result selectAll(Integer page,Integer limit) {
        Result result=new Result();
        page=(page-1)*limit;
        List<Flower> list =flowerMapper.selectAll(page,limit);
        Long count= flowerMapper.countFlower();
        result.setCount(count);
        result.setData(list);
        result.setCode(0);
        return result;
    }

    @Override
    public Result add(String name,Double buy,Double sell,Double cost,Double price,String role ) {
        Result result=new Result();
        Flower flower=new Flower();
        flower.setId(UUID.randomUUID().toString());
        flower.setName(name);
        flower.setBuy(buy);
        flower.setSell(sell);
        flower.setCost(cost);
        flower.setPrice(price);
        flower.setRole(role);
        int i = flowerMapper.insert(flower);
        if(i>0){
            result.setCode(200);
        }
        else{
            result.setCode(500);
        }
        return result;
    }

    @Override
    public Result deleteById(String[] ids) {
        Result result=new Result();
        try{
            for (int i = 0; i < ids.length; i++) {
                int p = flowerMapper.deleteByPrimaryKey(ids[i]);
            }
            result.setMsg("Success");
            result.setCode(200);
            return result;
        }catch (Exception e){
            e.printStackTrace();  //在控制台打印输出错误信息
            result.setMsg("系统繁忙，请刷新页面再进行尝试！");
            result.setCode(500);
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
    }

    @Override
    public Result getAll(Integer page, Integer limit) {

        return  null;
    }

    @Override
    public Result rank() {
        List<Flower> list= flowerMapper.selectRank();
        Result result=new Result();
        result.setCode(0);
        result.setData(list);
        return result;
    }

    @Override
    public Result selectByName(String name) {
        System.out.println("看这里"+name);
        List<Flower> list= flowerMapper.selectByName(name);
        Result result=new Result();
        result.setCode(0);
        result.setData(list);
        return result;
    }
}
