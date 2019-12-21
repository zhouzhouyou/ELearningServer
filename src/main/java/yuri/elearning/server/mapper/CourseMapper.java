package yuri.elearning.server.mapper;

import org.apache.ibatis.annotations.Insert;
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

    @Select("select * from course where id = #{id}")
    Course select(Integer id);

    @Select("select name from course where id = #{id}")
    String selectCourseName(Integer id);

    @Select("select syllabus from course where id = #{id}")
    String selectSyllabus(Integer id);

    @Select("select teacher from course where id = #{id}")
    String selectTeacher(Integer id);

    @Select("select cost from course where id = #{id}")
    Double selectCost(Integer id);
}
