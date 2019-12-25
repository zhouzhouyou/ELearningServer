package yuri.elearning.server.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class LessonPartMessage {
    private Course course;

    private List<Message> messages;

    @AllArgsConstructor
    @ApiModel("课程信息")
    @Data
    public static class Message {
        private String title;

        private Date time;

        private Integer id;
    }


}
