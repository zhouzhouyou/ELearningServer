package yuri.elearning.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import yuri.elearning.server.model.Category;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper {
    @Select("select * from category")
    List<Category> selectAll();

    @Select("select * from category where id = #{id}")
    Category select(Integer id);

    @Select("select name from category where id = #{id}")
    String selectCategoryName(Integer id);
}
