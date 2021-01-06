package team.eight.florist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.eight.florist.pojo.Result;
import team.eight.florist.service.FlowerService;

@Controller
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Result selectAll(Integer page,Integer limit){
        Result result= flowerService.selectAll(page,limit);
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(String name,Double buy,Double sell,Double cost,Double price,String role){
        Result result= flowerService.add(name,buy,sell,cost,price,role);
        return result;
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public Result deleteById(String[] ids){
        Result result= flowerService.deleteById(ids);
        return result;
    }

    @RequestMapping("/getAll")
    @ResponseBody  //自动将数据转换为json格式的数据并且避免被视图解析器解析
    public Result getAll(Integer page, Integer limit){
        //如果要携带数据并且是进行页面跳转？ thymeleaf模板（后面在教学）
        //得到我们视频信息
        Result result= flowerService.getAll(page,limit);
        return result;
    }

    @RequestMapping("/rank")
    @ResponseBody
    public Result rank(){
        Result result= flowerService.rank();
        return result;
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public Result selectByName(String name){
        Result result= flowerService.selectByName(name);
        return result;
    }
}
