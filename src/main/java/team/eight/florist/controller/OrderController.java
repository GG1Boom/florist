package team.eight.florist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.eight.florist.pojo.Result;
import team.eight.florist.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/selectById")
    @ResponseBody
    public Result selectById(String id){
        Result result= orderService.selectById(id);
        return result;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Result selectAll(Integer page,Integer limit){
        Result result= orderService.selectAll(page,limit);
        return result;
    }
}
