package yuri.elearning.server.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Lesson {
    private Integer id;

    private String title;

    private String content;

    private Integer cid;

    private Date time;

    private String video;
}
