package team.eight.florist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.eight.florist.pojo.Result;
import team.eight.florist.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    @ResponseBody
    public Result add(String id,String username,String nickname,Integer phoneNumber,String rId,String address){
        Result result= userService.add(id,username,nickname,phoneNumber,rId,address);
        return result;
    }
}
