package yuri.elearning.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import yuri.elearning.server.model.User;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where name=#{name} and password=#{password}")
    User select(String name, String password);

    @Select("select id from user where name=#{name} and password=#{password}")
    Integer selectUid(String name, String password);

    @Select("select money from user where id=#{id}")
    Double queryMoney(Integer id);

    @Update("update user set money = money - #{cost} where id=#{id}")
    void purchase(Integer id, Double cost);

    @Update("update user set money = money + #{cost} where id=#{id}")
    void recharge(Integer id, Double cost);

    @Update("update user set password=#{password} where id=#{id}")
    void resetPassword(Integer id, String password);
}
