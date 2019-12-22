package yuri.elearning.server.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TypeMapper {
    @Select("select course from type where category = #{category}")
    List<Integer> selectAllCourseByCategory(Integer category);

    @Select("select category from type where course = #{course}")
    List<Integer> selectAllCategoryByCourse(Integer course);
}
