package team.eight.florist.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import team.eight.florist.dao.FlowerMapper;
import team.eight.florist.dao.UsersMapper;
import team.eight.florist.pojo.Result;
import team.eight.florist.pojo.Users;
import team.eight.florist.service.FloristManageService;

@Service
public class FloristManageServiceImpl implements FloristManageService {
    @Autowired
    private FlowerMapper flowerMapper;
    @Autowired
    private UsersMapper usersMapper;


    @Transactional
    @Override
    public Result deleteById(String[] ids) {
        Result result = new Result();

        try {
            for (int i = 0; i < ids.length; i++) {
                int p = usersMapper.deleteByPrimaryKey(ids[i]);
            }
            result.setMsg("SUCCESS");
            result.setCode(200);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("系统繁忙，请刷新页面在进行尝试！");
            result.setCode(500);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
    }

    @Transactional
    @Override
    public Result add(Users users) {
        Result result = new Result();
        try {
            int i = usersMapper.insert(users);
            if (i > 0) {
                result.setCode(200);
            } else {
                result.setCode(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setCode(500);
            return result;
        }
        return result;
    }

}
