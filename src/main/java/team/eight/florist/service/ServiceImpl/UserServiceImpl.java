package team.eight.florist.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.eight.florist.dao.UsersMapper;
import team.eight.florist.pojo.Result;
import team.eight.florist.pojo.Users;
import team.eight.florist.service.UserService;
import team.eight.florist.util.Md5Utils;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Result login(String username, String password, String code, HttpServletRequest request) {
        Result result=new Result();
        String validateCode = (String) request.getSession().getAttribute("code");
        if(validateCode.equalsIgnoreCase(code)){
            Users users=usersMapper.selectByUsername(username);
            if(users!=null && users.getPassword().equals(Md5Utils.encryption(username,password))){
                result.setCode(200);
                result.setMsg("Success");
                request.getSession().setAttribute("users",users);
            }else{
                result.setCode(500);
                result.setMsg("用户名或密码错误！");
            }
        }else{
            result.setCode(500);
            result.setMsg("验证码错误！");
        }
        return result;
    }

    @Override
    public Result add(String id, String username, String nickname, Integer phoneNumber, String rId, String address) {
        Result result=new Result();
        Users users=new Users();
        users.setId(id);
        users.setUsername(username);
        users.setNickname(nickname);
        users.setPhoneNumber(phoneNumber);
        users.setrId(rId);
        users.setAddress(address);
        int i = usersMapper.insert(users);
        if(i>0){
            result.setCode(200);
        }
        else{
            result.setCode(500);
        }
        return result;
    }
}
