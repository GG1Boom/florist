package team.eight.florist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.eight.florist.pojo.Result;
import team.eight.florist.pojo.Users;
import team.eight.florist.service.FloristManageService;

@Controller
@RequestMapping("/floristManage")
public class FloristManageController {

    @Autowired
    FloristManageService floristManageService;

//    会员信息管理
    @RequestMapping("/add")
    @ResponseBody
    public Result add(Users users){
        Result result = floristManageService.add(users);
        return result;
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public Result deleteById(String[] ids){
        Result result= floristManageService.deleteById(ids);
        return result;
    }

}
