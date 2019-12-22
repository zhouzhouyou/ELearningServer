package yuri.elearning.server.model;

import lombok.Data;

@Data
public class CoursePartMessage {
    private Integer id;

    private String cover;

    public CoursePartMessage(Integer id, String cover) {
        this.id = id;
        this.cover = cover;
    }
}