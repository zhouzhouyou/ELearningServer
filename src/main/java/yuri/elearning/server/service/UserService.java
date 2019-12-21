package yuri.elearning.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yuri.elearning.server.mapper.UserMapper;
import yuri.elearning.server.model.User;
import yuri.elearning.server.util.RF;

import java.util.List;

@Service
@Component
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ResponseEntity<List<User>> selectAll() {
        return RF.success(userMapper.selectAll());
    }

    public ResponseEntity<Integer> signIn(String name, String password) {
        Integer id = userMapper.selectUid(name,password);
        if(id == null)
            return RF.badRequest(null);
        return RF.success(id);
    }

    public ResponseEntity<String> signUp(String name,String password){
        Integer count = userMapper.insert(name,password);
        if(count == 0)
            return RF.badRequest("fail");
        return RF.success("success");
    }

    public ResponseEntity<String> recharge(Integer id,Double cost){
        userMapper.recharge(id,cost);
        return RF.success("success");
    }
}
