package team.eight.florist.service;

import org.springframework.stereotype.Service;
import team.eight.florist.pojo.Result;

import javax.servlet.http.HttpServletRequest;

@Service
public interface UserService {
    Result login(String username, String password, String code, HttpServletRequest request);

    Result add(String id, String username, String nickname,Integer phoneNumber,String rId, String address);
}
