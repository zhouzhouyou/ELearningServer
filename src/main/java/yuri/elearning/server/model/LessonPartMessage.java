package yuri.elearning.server.model;

import lombok.Data;

import java.sql.Date;

@Data
public class LessonPartMessage {
    private String title;

    private Date time;

    private Integer id;

    public LessonPartMessage(String title, Date time, Integer id) {
        this.title = title;
        this.time = time;
        this.id = id;
    }
}
