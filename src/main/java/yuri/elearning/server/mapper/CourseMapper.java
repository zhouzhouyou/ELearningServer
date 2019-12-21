package yuri.elearning.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import yuri.elearning.server.model.Course;

import java.util.List;

@Mapper
@Component
public interface CourseMapper {
    @Select("select * from course")
    List<Course> selectAll();
}
