package team.eight.florist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.eight.florist.pojo.Result;
import team.eight.florist.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/class")
    @ResponseBody
        public Result floralClassfication(String role){
        Result result = memberService.floralClassfication(role);
        return result;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Result selectAll(){
        Result result = memberService.selectAll();
        return result;
    }

}
