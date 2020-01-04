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

    public ResponseEntity<User> signIn(String name, String password) {
        User user = userMapper.select(name, password);
        return user == null ? RF.badRequest(null) : RF.success(user);
    }

    public ResponseEntity<Integer> signUp(String name, String password) {
        Integer id = -1;
        User user = new User(id,name,password,0.0);
//        user.setMoney(0.0);
//        user.setName(name);
//        user.setPassword(password);
        Integer count = userMapper.insert(user);
        return count == 0 ? RF.badRequest(-1) : RF.success(user.getId());
    }

    public ResponseEntity<Double> recharge(Integer id, Double cost) {
        userMapper.recharge(id, cost);
        return RF.success(userMapper.queryMoney(id));
    }
}
