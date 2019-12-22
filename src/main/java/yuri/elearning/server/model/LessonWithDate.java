package yuri.elearning.server.model;

import lombok.Data;

import java.sql.Date;

@Data
public class LessonWithDate {
    private Date time;

    private String title;

    private String courseName;

    private Integer id;

    public LessonWithDate(Date time, String title, String courseName, Integer id) {
        this.time = time;
        this.title = title;
        this.courseName = courseName;
        this.id = id;
    }
}
