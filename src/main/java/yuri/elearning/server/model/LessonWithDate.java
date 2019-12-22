package yuri.elearning.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class LessonWithDate {
    private Date time;

    private String title;

    private String courseName;

    private Integer id;

}
