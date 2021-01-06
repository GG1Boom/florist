package team.eight.florist.controller;

import cn.dsna.util.images.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.eight.florist.pojo.Result;
import team.eight.florist.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/index")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/main")
    public String main(){
        return "login";
    }

    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        ValidateCode validateCode=new ValidateCode(120,30,5,50);
        request.getSession().setAttribute("code",validateCode.getCode());
        try {
            validateCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/login")
    @ResponseBody
    public Result login(String username,String password,String code,HttpServletRequest request){
        Result result=userService.login(username,password,code,request);
        return result;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
