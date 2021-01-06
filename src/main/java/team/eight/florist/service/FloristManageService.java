package team.eight.florist.service;

import org.springframework.stereotype.Service;
import team.eight.florist.pojo.Result;
import team.eight.florist.pojo.Users;

@Service
public interface FloristManageService {

     Result deleteById(String[] ids);

     Result add(Users users);

}
