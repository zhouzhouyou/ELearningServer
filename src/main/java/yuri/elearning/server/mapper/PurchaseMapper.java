package yuri.elearning.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PurchaseMapper {
    @Select("select uid from purchase where cid = #{cid}")
    List<Integer> selectAllUserOfCourse(Integer cid);

    @Select("select cid from purchase where uid = #{uid}")
    List<Integer> selectAllCourseOfUser(Integer uid);
}
