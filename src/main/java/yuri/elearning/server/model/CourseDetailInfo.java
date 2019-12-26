package yuri.elearning.server.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
@AllArgsConstructor
public class CourseDetailInfo {
    private Course course;

    private List<LessonBriefInfo> lessonBriefInfos;

}
