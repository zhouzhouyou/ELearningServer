package yuri.elearning.server.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import yuri.elearning.server.model.Bookmark;

import java.util.List;

@Component
@Mapper
public interface BookmarkMapper {
    @Select("select * from bookmark where uid = #{uid}")
    List<Bookmark> select(Integer uid);

    @Insert("insert into bookmark values(#{uid},#{did})")
    Integer insert(Integer uid, Integer did);

    @Delete("delete from bookmark where uid = #{uid} and did = #{did}")
    Integer delete(Integer uid,Integer did);
}
