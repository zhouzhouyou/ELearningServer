package yuri.elearning.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import yuri.elearning.server.model.Lesson;

import java.util.List;

@Mapper
@Component
public interface LessonMapper {
    @Select("select * from lesson where cid = #{cid}")
    List<Lesson> selectAllOfCourse(Integer cid);

    @Select("select * from lesson where id = #{id}")
    Lesson select(Integer id);

    @Select("select * from lesson where month(time) = #{month} and year(time) = #{year} and cid = #{cid}")
    List<Lesson> selectAllLessonWithDate(Integer cid, Integer month, Integer year);
}
