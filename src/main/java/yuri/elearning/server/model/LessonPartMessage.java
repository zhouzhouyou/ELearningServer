package yuri.elearning.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class LessonPartMessage {
    private Course course;

    private String title;

    private Date time;

    private Integer id;

}
