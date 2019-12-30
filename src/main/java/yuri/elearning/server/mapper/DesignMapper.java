package yuri.elearning.server.mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import yuri.elearning.server.model.Design;

import java.util.List;

@Mapper
@Component
public interface DesignMapper {
    @Select("select * from design")
    List<Design> selectAll();

    @Select("select * from design where uid = #{uid}")
    List<Design> selectByUid(Integer uid);

    @Select("select * from design where id = #{id}")
    Design select(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "design.id")
    @Insert("insert into design (name,p,pl,pd,s,sl,sd,tp,ts,uid) values(#{design.name},#{design.p},#{design.pl},#{design.pd},#{design.s},#{design.sl},#{design.sd},#{design.tp},#{design.ts},#{design.uid})")
    void insert(@Param("design") Design design);

    @Delete("delete from design where id = #{id}")
    Integer delete(Integer id);
}
