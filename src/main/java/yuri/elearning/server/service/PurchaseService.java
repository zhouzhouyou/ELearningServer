package yuri.elearning.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yuri.elearning.server.mapper.CourseMapper;
import yuri.elearning.server.mapper.PurchaseMapper;
import yuri.elearning.server.mapper.UserMapper;
import yuri.elearning.server.util.RF;

import java.util.List;

@Service
@Component
public class PurchaseService {
    private final PurchaseMapper purchaseMapper;
    private final UserMapper userMapper;
    private final CourseMapper courseMapper;

    @Autowired
    public PurchaseService(PurchaseMapper purchaseMapper, UserMapper userMapper, CourseMapper courseMapper) {
        this.purchaseMapper = purchaseMapper;
        this.userMapper = userMapper;
        this.courseMapper = courseMapper;
    }

    public ResponseEntity<Double> purchaseCourse(Integer uid, Integer cid) {
        Double currentAccount = userMapper.queryMoney(uid);
        Double cost = courseMapper.selectCost(cid);
        if (currentAccount < cost)
            return RF.badRequest(null);
        userMapper.purchase(uid, cost);
        purchaseMapper.insert(uid, cid);
        return RF.success(userMapper.queryMoney(uid));
    }

    public ResponseEntity<List<Integer>> queryMyCourses(Integer uid) {
        return RF.success(purchaseMapper.selectAllCourseOfUser(uid));
    }
}
