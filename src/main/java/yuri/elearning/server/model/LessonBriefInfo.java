package yuri.elearning.server.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@ApiModel
@Data
@AllArgsConstructor
public class LessonBriefInfo {
    private String title;

    private Date time;

    private Integer id;

    private Integer cid;
}
