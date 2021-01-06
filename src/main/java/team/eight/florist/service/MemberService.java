package team.eight.florist.service;

import org.springframework.stereotype.Service;
import team.eight.florist.pojo.Result;

@Service
public interface MemberService {

    Result floralClassfication(String role);

    Result selectAll();
}
